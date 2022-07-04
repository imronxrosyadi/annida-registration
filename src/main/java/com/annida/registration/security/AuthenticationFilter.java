package com.annida.registration.security;

import com.annida.registration.model.User;
import com.annida.registration.model.dto.AdditionalInfoDto;
import com.annida.registration.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private UserService userService;
    private final ObjectMapper objectMapper;

    public AuthenticationFilter(AuthenticationManager authenticationManager, UserService usersService, ObjectMapper objectMapper) {
        this.authenticationManager = authenticationManager;
        this.userService = usersService;
        this.objectMapper = objectMapper;
        super.setFilterProcessesUrl("/api/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        User user = new User();
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        String username = authResult.getName();
        User user = new User();
        try {
            user = this.userService.getByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String secretKey = "$2a$10$/6GvrEQhD4cf5SoMdTaSsuHxAWO31tktM576gpDrgKhph8yHFVBBeAWO31tktM576gpDrgKhph8yHFVBBe";
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        AdditionalInfoDto additionalInfoDto = new AdditionalInfoDto(user.getId(), user.getUsername(), user.isAdmin());

        String token = Jwts.builder()
                .signWith(key)
                .setSubject(user.getId())
//                .claim("additionalInfo", additionalInfoDto)
                .setExpiration(
                        Date.from(LocalDateTime.now()
                                .plusDays(1)
                                .atZone(ZoneId.systemDefault())
                                .toInstant()))
                .compact();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        JSONObject userProfile = new JSONObject();
        userProfile.put("userId", user.getId());
        userProfile.put("username", user.getUsername());
        userProfile.put("isAdmin", user.isAdmin());

        JSONObject loginResponse = new JSONObject();
        loginResponse.put("token", token);
        loginResponse.put("additionalInfo", userProfile);

//        response.getWriter().write(objectMapper
//                .writeValueAsString(userProfile));

        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        out.print(loginResponse);
        out.flush();

//        response.getWriter().append("{\"token\" : \"" + "Bearer " + token + "\",").append("\"profile\" : {")
//                .append("\"userId\" : \"" + user.getId() + "\",")
////                .append("\"profileId\" : \"" + user.getIdProfile().getId() + "\",")
//                .append("\"isAdmin\" : \"" + user.isAdmin() + "\"}").append("}");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        if (failed.getMessage().equals("Bad credentials")
                || failed.getMessage().contains("UserDetailsService returned null")) {
            response.setContentType("application/json");
//            response.getWriter().append("Username or Password is incorrect");

            JSONObject json = new JSONObject();
            json.put("status", HttpStatus.BAD_REQUEST);
            json.put("code", 400);
            json.put("data", (Object) null);
            json.put("message", "Username atau Password salah");

            PrintWriter out = response.getWriter();
            response.setCharacterEncoding("UTF-8");
            out.print(json);
            out.flush();
        }
    }

}

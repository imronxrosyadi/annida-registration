package com.annida.registration.controller;

import com.annida.registration.helper.Response;
import com.annida.registration.model.dto.RegisterUserDto;
import com.annida.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Response<?> insert(@RequestBody RegisterUserDto user) {
        try {
            userService.insert(user);
            return new Response<>(HttpStatus.CREATED, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null, e.getMessage());
        }
    }

}

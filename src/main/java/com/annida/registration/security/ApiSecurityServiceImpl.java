package com.annida.registration.security;

import org.springframework.security.core.userdetails.User;
import com.annida.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApiSecurityServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            com.annida.registration.model.User userDb = userService.getByUsername(username);
            if (userDb != null) {
                return new User(userDb.getUsername(), userDb.getPassword(), new ArrayList<>());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.annida.registration.service;

import com.annida.registration.model.User;
import com.annida.registration.model.dto.RegisterUserDto;

import java.util.List;

public interface UserService {

    List<User> getAll() throws Exception;

    void insert(RegisterUserDto user) throws Exception;

    void deleteById(String id) throws Exception;

    User getById(String id) throws Exception;

    User getByUsername(String username) throws Exception;

    User changePassword(User user) throws Exception;

}

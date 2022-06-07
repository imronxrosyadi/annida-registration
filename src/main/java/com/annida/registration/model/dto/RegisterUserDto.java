package com.annida.registration.model.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String username;
    private String password;
    private String name;
    private String email;
}

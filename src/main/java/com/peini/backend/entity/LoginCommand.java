package com.peini.backend.entity;


import lombok.Data;

@Data
public class LoginCommand {
    private String username;

    private String password;

    private boolean rememberMe;
}

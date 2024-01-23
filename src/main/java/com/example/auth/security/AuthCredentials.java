package com.example.auth.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AuthCredentials {
    private String email;
    private String password;



}

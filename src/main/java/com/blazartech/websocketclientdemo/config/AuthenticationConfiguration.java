/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo.config;

import java.util.Base64;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author scott
 */
@Configuration
public class AuthenticationConfiguration {
    
    @Bean
    public String base64Auth() {
        String username = "auditor";
        String password = "password";

        String auth = username + ":" + password;
        String base64Auth = Base64.getEncoder().encodeToString(auth.getBytes());
        
        return base64Auth;
    }
}

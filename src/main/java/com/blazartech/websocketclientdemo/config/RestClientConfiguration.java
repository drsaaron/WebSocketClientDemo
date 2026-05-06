/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo.config;

import java.io.IOException;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestClient;

/**
 *
 * @author scott
 */
@Configuration
public class RestClientConfiguration {
    
    @Slf4j
    private static class LoggingInterceptor implements ClientHttpRequestInterceptor {

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            log.info("sending {} request to {}", request.getMethod(), request.getURI());
            
            ClientHttpResponse response = execution.execute(request, body);
            log.info("response code = {}", response.getStatusText());
            
            return response;
        }
        
    }
    
    @Bean
    public RestClient restClient() {
        String username = "auditor";
        String password = "password";

        String auth = username + ":" + password;
        String base64Auth = Base64.getEncoder().encodeToString(auth.getBytes());
        
        return RestClient.builder()
                .defaultHeader("Authorization", "Basic " + base64Auth)
                .baseUrl("http://localhost:8700/api/messages")
                .requestInterceptor(new LoggingInterceptor())
                .build();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo.config;

import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.messaging.WebSocketStompClient;

/**
 *
 * @author aar1069
 */
@Configuration
@Slf4j
public class StompSessionConfiguration {
    
    @Autowired
    private WebSocketStompClient stompClient;

    @Autowired
    private StompSessionHandlerAdapter clientSessionHandler;
    
    @Bean
    public StompSession stompSession() throws Exception {
        String url = "ws://localhost:8700/ws";

        String username = "auditor";
        String password = "password";

        WebSocketHttpHeaders handshakeHeaders = new WebSocketHttpHeaders();
        String auth = username + ":" + password;
        String base64Auth = Base64.getEncoder().encodeToString(auth.getBytes());
        handshakeHeaders.add("Authorization", "Basic " + base64Auth);
//        handshakeHeaders.setBasicAuth(username, password);
        
        return stompClient.connectAsync(
                url,
                handshakeHeaders,
                clientSessionHandler
        ).get();
    }
}

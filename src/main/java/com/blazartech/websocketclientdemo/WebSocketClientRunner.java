/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo;

import java.util.Base64;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.messaging.WebSocketStompClient;

/**
 *
 * @author aar1069
 */
@Component
@Slf4j
public class WebSocketClientRunner implements CommandLineRunner {

    @Autowired
    private WebSocketStompClient stompClient;

    @Autowired
    private StompSessionHandlerAdapter clientSessionHandler;
            
    @Override
    public void run(String... args) throws Exception {

        String url = "ws://localhost:8700/ws";

        String username = "auditor";
        String password = "password";

        WebSocketHttpHeaders handshakeHeaders = new WebSocketHttpHeaders();
        String auth = username + ":" + password;
        String base64Auth = Base64.getEncoder().encodeToString(auth.getBytes());
        handshakeHeaders.add("Authorization", "Basic " + base64Auth);
//        handshakeHeaders.setBasicAuth(username, password);
        
        StompSession session = stompClient.connectAsync(
                url,
                handshakeHeaders,
                clientSessionHandler
        ).get();
        
        log.info("connected");
        
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
        }
    }
}

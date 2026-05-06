/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.JacksonJsonMessageConverter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

/**
 *
 * @author aar1069
 */

@Configuration
public class WebSocketClientConfiguration {

    @Bean
    public WebSocketStompClient stompClient() {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        
        SockJsClient sockjsClient = new SockJsClient(List.of(new WebSocketTransport(webSocketClient)));  

        WebSocketStompClient stompClient = new WebSocketStompClient(sockjsClient);

        stompClient.setMessageConverter(new JacksonJsonMessageConverter());

        return stompClient;
    }
}


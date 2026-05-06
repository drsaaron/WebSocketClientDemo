/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo;

import com.blazartech.websocketclientdemo.data.ChatMessage;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 *
 * @author scott
 */
@Component
@Slf4j
public class FetchOfflineMessagesCommandLIneRunner implements CommandLineRunner {
 
    @Autowired
    private RestClient restClient;

    @Override
    public void run(String... args) throws Exception {
        log.info("fetching offline messages");
        
        ChatMessage[] offlineMessages = restClient.get()
                .uri("/offline")
                .retrieve()
                .toEntity(ChatMessage[].class)
                .getBody();
        
        Stream.of(offlineMessages).forEach(m -> log.info("offline message {}", m));
    }
    
    
}

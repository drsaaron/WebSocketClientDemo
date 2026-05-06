/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo;

import com.blazartech.websocketclientdemo.data.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Component;

/**
 *
 * @author scott
 */
@Component
@Slf4j
public class AnnouncePresenceCommandLineRunner implements CommandLineRunner {

    @Autowired
    private StompSession stompSession;
    
    @Override
    public void run(String... args) throws Exception {
        log.info("announcing my presence");
        
        ChatMessage hi = new ChatMessage();
        hi.setContent("be aware that I am listening");
        hi.setSender("auditor");
        
        stompSession.send("/app/chat.public", hi);
    }
    
}

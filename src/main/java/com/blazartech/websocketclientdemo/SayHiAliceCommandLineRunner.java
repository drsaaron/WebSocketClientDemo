/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo;

import com.blazartech.websocketclientdemo.data.ChatMessage;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Component;

/**
 *
 * @author scott
 */
@Component
@Slf4j
@Order(3)
public class SayHiAliceCommandLineRunner implements CommandLineRunner {

    @Autowired
    private StompSession stompSession;

    @Autowired
    private Map<String, String> pendingMessages;

    @Override
    public void run(String... args) throws Exception {
        log.info("sending private message to Alice");

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRecipient("alice");
        chatMessage.setContent("hello alice, I'm the auditor");

        String uuid = UUID.randomUUID().toString();
        chatMessage.setClientMessageId(uuid);

        // We need a way to access the pendingMessages map from the runner.
        // A clean way is to pass the map into the SessionHandler, or just track it at the class level.
        // (Assuming you've moved the Map to the outer ChatClientRunner class for scope access):
        pendingMessages.put(uuid, chatMessage.getContent());
        log.info("adding pending message to queue: {}", pendingMessages);

        stompSession.send("/app/chat.private", chatMessage);
    }

}

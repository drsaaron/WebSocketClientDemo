/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo.handler;

import java.lang.reflect.Type;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.stereotype.Component;

/**
 *
 * @author scott
 */
@Component
@Slf4j
public class DeliveryNotificationHandler implements StompFrameHandler {

    @Autowired
    private Map<String, String> pendingMessages;
    
    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        log.info("got delivery notification {}", payload);
        log.info("pending messages = {}", pendingMessages);
        
        String clientMsgId = (String) payload;
        String originalText = pendingMessages.remove(clientMsgId);

        if (originalText != null) {
            log.info("\n[✓ Delivered] Your message: '" + originalText + "' has been received.");
        }
    }

}

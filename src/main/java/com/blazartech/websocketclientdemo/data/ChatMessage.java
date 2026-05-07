/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo.data;

import lombok.Data;

/**
 *
 * @author aar1069
 */
@Data
public class ChatMessage {
    
    private Long id;
    private String sender;
    private String content;
    private String recipient;
    
    private String clientMessageId;
}

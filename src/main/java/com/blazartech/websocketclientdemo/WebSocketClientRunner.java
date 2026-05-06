/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.websocketclientdemo;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
@Slf4j
public class WebSocketClientRunner implements CommandLineRunner {
            
    @Override
    public void run(String... args) throws Exception {
        
        // wait for input as a hack to keep the app running
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
        }
    }
}

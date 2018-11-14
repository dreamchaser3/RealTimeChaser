package com.realtimechaser.rudpserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServerBySpring {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ServerBySpring.class, args);
        Server server = context.getBean(Server.class);
        server.start();
    }
}

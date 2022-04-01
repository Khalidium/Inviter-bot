package com.example.inviter;

import com.example.inviter.discord.Discord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class InviterApplication {

    public static void main(String[] args) {
        SpringApplication.run(InviterApplication.class, args);
    }

}

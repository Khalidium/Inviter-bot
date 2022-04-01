package com.example.inviter.discord;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component("Discord")
public class Discord {
    public JDA jda;
    private List<String> codes;

    public Discord() throws LoginException {

        jda = JDABuilder.createDefault("OTQzMDkyODIxODY5NTkyNjM3.YguBog.qlXncOhjf0Wz_Cj9zEJx5_crC4U").build();
        jda.getPresence().setActivity(Activity.playing("Inviting folks"));
        codes = new ArrayList<>();
        CodeGenerator.fillList(codes, 50);
        jda.addEventListener(new DiscordEvents(codes));
    }

    public List<String> getCodes(){
        return codes;
    }
}

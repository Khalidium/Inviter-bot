package com.example.inviter.discord;

import java.util.List;
import java.util.Random;

public class CodeGenerator {
    public static String generateCode(){

        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String code = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
                .collect(StringBuilder::new,StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return code;
    }

    public static void fillList(List<String> codes, int values){
        for(int i = 0; i < values; i++){
            codes.add(generateCode());
        }
    }
}

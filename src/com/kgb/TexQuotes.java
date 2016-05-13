package com.kgb;

/**
 * Created by k.betlej on 11/9/15.
 */
public class TexQuotes {

    public static String replaceQuota(String input) {
        int index = input.indexOf("\"");
        String[] replacement = { "``", "''"};
        int repIndex = 0;
        while(index != -1) {
            input = input.replaceFirst("\"", replacement[repIndex]);
            repIndex = repIndex == 0 ? 1 : 0;
            index = input.indexOf("\"");
        }
        return input;
    }
}

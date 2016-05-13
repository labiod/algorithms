package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/29/16.
 */
public class LoveLetterMystary {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t0"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        int T = sc.nextInt();
        for(int ts = 0; ts < T; ++ts) {
            String text = sc.next();
            int operationCount = 0;
            for(int i = 0; i < text.length()/2; ++i) {
                char start = text.charAt(i);
                char end = text.charAt(text.length() - 1 - i);
                operationCount += Math.abs(start - end);
            }
            System.out.println(operationCount);
        }
    }
}

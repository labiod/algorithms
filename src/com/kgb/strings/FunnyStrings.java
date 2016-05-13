package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/22/16.
 */
public class FunnyStrings {


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t2"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int T = sc.nextInt();

        for(int ts = 0; ts < T; ++ts) {
            String text = sc.next();
            boolean corrected = true;
            for(int i = 0; i < text.length(); i+=2) {
                int firstRegion;
                if(i < text.length() - 1) {
                    firstRegion = Math.abs(text.charAt(i) - text.charAt(i+1));
                } else {
                    firstRegion = Math.abs(text.charAt(i) - text.charAt(i-1));
                }

                int secondRegion;
                if(i < text.length() - 1) {
                    secondRegion = Math.abs(text.charAt(text.length() - 1 - i) - text.charAt(text.length() - 2 - i));
                } else {
                    secondRegion = Math.abs(text.charAt(text.length() - 1 - i) - text.charAt(text.length() - i));
                }
                if (firstRegion != secondRegion) {
                    corrected = false;
                    break;
                }
            }
            if (corrected) {
                System.out.println("Funny");
            } else {
                System.out.println("Not Funny");
            }

        }
    }
}

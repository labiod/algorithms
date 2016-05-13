package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/22/16.
 */
public class AlternatingCharacters {

    public static final char FLAG_A = 'A';
    public static final char FLAG_B = 'B';

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t0"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int T = sc.nextInt();

        for(int ts = 0; ts < T; ++ts) {
            String text = sc.next();
            char letterFlag = text.charAt(0);
            int delation = 0;
            for(int i = 1; i < text.length(); ++i) {
                if(letterFlag != text.charAt(i)) {
                    letterFlag = letterFlag == FLAG_A ? FLAG_B : FLAG_A;
                } else {
                    delation++;
                }
            }
            System.out.println(delation);

        }
    }
}

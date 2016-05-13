package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/22/16.
 */
public class Anagram {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t0"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        int T = sc.nextInt();
        for(int i =0; i < T; ++i) {
            String text = sc.next();
            if(text.length() % 2 != 0) {
                System.out.println(-1);
                continue;
            }
            String s1 = text.substring(0, text.length()/2);
            String s2 = text.substring(text.length()/2, text.length());
            List<Character> missingLetter = new ArrayList<Character>();
            for(int k = 0; k < s2.length(); ++k) {
                missingLetter.add(s2.charAt(k));
            }
            for(int k = 0; k < s1.length(); ++k) {
                Character c = s1.charAt(k);
                if(missingLetter.contains(c)) {
                    missingLetter.remove(c);
                }
            }
            System.out.println(missingLetter.size());
        }

    }
}

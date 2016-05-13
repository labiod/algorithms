package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/22/16.
 */
public class GameOfThrones {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t2"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        String text = sc.next();
        HashMap<Character, Integer> letterCounter = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); ++i) {
            char letter = text.charAt(i);
            if (letterCounter.containsKey(letter)) {
                letterCounter.put(letter, letterCounter.get(letter) + 1);
            } else {
                letterCounter.put(letter, 1);
            }
        }
        int notEvenCount = 0;
        for (Map.Entry<Character, Integer> entry : letterCounter.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                notEvenCount++;
            }
        }
        if (notEvenCount > 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}

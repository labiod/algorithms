package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/22/16.
 */
public class MakeItAnagram {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t1"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        String text1 = sc.next();
        String text2 = sc.next();
        List<Character> letters1 = new ArrayList<Character>();
        for(int i =0; i < text1.length(); ++i) {
            letters1.add(text1.charAt(i));
        }
        int incorrectCount = 0;
        for(int i =0; i < text2.length(); ++i) {
            Character c = text2.charAt(i);
            if(letters1.contains(c)) {
                letters1.remove(c);
            } else {
                incorrectCount++;
            }
        }
        System.out.println(letters1.size()+incorrectCount);
    }
}

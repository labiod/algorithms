package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/22/16.
 */
public class TwoStrings {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t1"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        int T = sc.nextInt();
        for(int ts =0; ts < T; ++ts) {
            String text1 = sc.next();
            String text2 = sc.next();
            String greaterString = text1.length() >= text2.length() ? text1 : text2;
            String lessString = greaterString.equals(text1) ? text2 : text1;
            List<Character> all = getAllChar(greaterString);
            boolean isSubSeq = false;
            for(int i = 0; i < lessString.length(); ++i) {
                if(all.isEmpty()) {
                    break;
                }
                Character c1 = lessString.charAt(i);
                if(all.remove(c1)) {
                    isSubSeq = true;
                    break;
                }
            }
            System.out.println(isSubSeq ? "YES" : "NO");
        }

    }

    private static List<Character> getAllChar(String greaterString) {
        List<Character> list = new ArrayList<Character>();
        for(int i = 0; i < greaterString.length(); ++i) {
            Character t = greaterString.charAt(i);
            if(!list.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }
}

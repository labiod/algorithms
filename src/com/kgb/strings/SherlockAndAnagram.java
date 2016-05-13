package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/25/16.
 */
public class SherlockAndAnagram {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t1"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        int T = sc.nextInt();
        for(int ts =0; ts < T; ++ts) {
            String text = sc.next();
            int groupCount = 0;
            for(int len = 1; len < text.length(); ++len) {
                for (int i = 0; i <= text.length() - len; ++i) {
                    String a1 = text.substring(i, i + len);
                    for (int j = text.length(); j - len > i; --j) {
                        String a2 = text.substring(j - len, j);
                        if (isAnagram(a1, a2)) {
                            groupCount++;
                        }
                    }
                }
            }
            System.out.println(groupCount);
        }
    }

    private static boolean isAnagram(String a1, String a2) {
        if(a1.equals(a2)) {
            return true;
        }
        List<Character> letters = new ArrayList<Character>();
        for(int i = 0; i < a1.length(); ++i) {
            letters.add(a1.charAt(i));
        }
        for(int j = 0; j < a2.length(); ++j) {
            Character c = a2.charAt(j);
            if(!letters.remove(c)) {
                return false;
            }
        }
        return letters.size() == 0;
    }
}

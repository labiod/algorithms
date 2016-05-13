package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 2/5/16.
 */
public class CommonChild {

    private static int[][] patterns;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t5"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        String text1 = sc.next();
        String text2 = sc.next();
        patterns = new int[text1.length()][text2.length()];
        int length = getLongestChild(text1, text2, 0, 0);
        System.out.println(length);
    }

    private static int getLongestChild(String text1, String text2, int i1, int i2) {

        int best = 0;
        if (i1 < text1.length() && i2 < text2.length()) {
            if (patterns[i1][i2] != 0) {
                return patterns[i1][i2];
            }
            char c1 = text1.charAt(i1);
            char c2 = ' ';
            int newIndex = 0;
            for(int i = i2; i < text2.length(); ++i) {
                if(c1 == text2.charAt(i)) {
                    c2 = text2.charAt(i);
                    newIndex = i;
                    break;
                }
            }
            if(c1 != c2) {
                return getLongestChild(text1, text2, i1+1, i2);
            }
            int t1 = 1 + getLongestChild(text1, text2, i1 + 1, newIndex + 1);
            int t2 = getLongestChild(text1, text2, i1+ 1, i2);
            if (t1 > t2) {
                best = t1;
            } else {
                best = t2;
            }

            patterns[i1][i2] = best;

        }
        return best;
    }
}

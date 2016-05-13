package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/27/16.
 */
public class ReverseShuffleMerge {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t2"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        String text = sc.next();
        int[] letters = new int[26];
        for(int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            int  index = convertToIndex(c);
            letters[index]++;

        }
        String pattern = getBestPattern(letters, new StringBuilder(text).reverse().toString());
        System.out.println(pattern);
    }

    private static String getBestPattern(int[] letters, String text) {
        int length = text.length()/2;
        int index = 0;
        String pattern = "";
        int[] usedLetter = new int[26];
        String subText = text;
        while(index < length) {
            char potentialChar = 'a';
            for (int i = 0; i < letters.length; ++i) {
                if(letters[i] > 0 && usedLetter[i] < letters[i]/2) {
                    potentialChar = convertToChar(i);
                    if (isPossible(subText, potentialChar, usedLetter, letters)) {
                        usedLetter[i]++;
                        break;
                    }
                }
            }
            index++;
            int k = subText.indexOf(potentialChar);
            subText = subText.substring(k + 1);
            pattern += potentialChar;
        }
        return pattern;
    }

    private static boolean isPossible(String subText, char potentialChar, int[] letterUsed, int[] letterNeeded) {
        int index = subText.indexOf(String.valueOf(potentialChar));
        if(index == -1) {
            return false;
        }
        subText = subText.substring(index);
        int[] availableLetter = new int[26];
        for(int i = 0; i < subText.length(); ++i) {
            char c = subText.charAt(i);
            int  k = convertToIndex(c);
            availableLetter[k]++;
        }
        for(int i = 0; i < availableLetter.length; ++i) {
            if(letterNeeded[i] == 0) {
                continue;
            }
            if(availableLetter[i] < letterNeeded[i] / 2 - letterUsed[i]) {
                return false;
            }
        }
        return true;
    }

    private static int convertToIndex(char c) {
        return c - 97;
    }

    private static char convertToChar(int index) {
        return (char)(index + 97);
    }
}

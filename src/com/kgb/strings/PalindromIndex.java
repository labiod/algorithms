package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/25/16.
 */
public class PalindromIndex {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t2"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        int T = sc.nextInt();
        for(int ts =0; ts < T; ++ts) {
            String text = sc.next();
            int palindromeBeginIndex = -1;
            List<Character> letters = new ArrayList<Character>();
            for(int i = 0; i < text.length(); ++i) {
                letters.add(text.charAt(i));
            }
            int index = 0;
            for(int i = 0; i < letters.size()/2; ++i) {
                Character c1 = letters.get(i);
                Character c2 = letters.get(letters.size() - 1 - i);
                if(c1 != c2) {
                    palindromeBeginIndex = findCharToRemove(letters, index);
                    break;
                }
                index++;
            }
            System.out.println(palindromeBeginIndex);
        }
    }

    private static int findCharToRemove(List<Character> letters, int index) {
        List<Character> o1 = new ArrayList<Character>(letters);
        o1.remove(index);
        List<Character> o2 = new ArrayList<Character>(letters);
        o2.remove(o2.size() - 1 - index);
        boolean isPalindrom = true;
        for(int i = 0; i < o1.size()/2; ++i) {
            if(o1.get(i) != o1.get(o1.size() - 1 - i)) {
                isPalindrom = false;
                break;
            }
        }
        if(isPalindrom) {
            return index;
        } else {
            return letters.size() - 1 - index;
        }
    }
}

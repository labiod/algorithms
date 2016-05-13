package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/22/16.
 */
public class Pangram {

    private static final int BIG_A = 65;
    private static final int SMALL_A = 97;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t1"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        String line = sc.nextLine();
        List<Character> characters = new ArrayList<Character>();
        boolean[] letterChecked = new boolean[26];
        for(int i =0; i <line.length(); ++i) {
            char c = line.charAt(i);
            int index = (int)c < 97 ? (int)c - BIG_A : (int)c - SMALL_A;
            if(index < 0) {
                continue;
            }
            letterChecked[index] = true;
        }
        boolean isPangram = true;

        for(int i = 0 ;i < letterChecked.length; ++i) {
            if(!letterChecked[i]) {
                isPangram = false;
                break;
            }
        }
        if(isPangram) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}

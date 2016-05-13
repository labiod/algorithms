package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by k.betlej on 1/22/16.
 */
public class Gemstones {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t0"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        int N = sc.nextInt();
        Map<Character, Integer> gemsElements = new HashMap<Character, Integer>();
        for(int i = 0; i <N; ++i) {
            String text = sc.next();
            List<Character> currentElements = new ArrayList<Character>();
            for(int j = 0; j < text.length(); ++j) {
                char letter = text.charAt(j);
                if(!currentElements.contains(letter)) {
                    currentElements.add(letter);
                    Integer count =  gemsElements.get(letter);
                    if(count == null) {
                        gemsElements.put(letter, 1);
                    } else {
                        gemsElements.put(letter, count+1);
                    }
                }
            }
        }
        int gemsCount = 0;
        for(Map.Entry<Character, Integer> entry : gemsElements.entrySet()) {
            if(entry.getValue() == N) {
                gemsCount++;
            }
        }
        System.out.println(gemsCount);
    }
}

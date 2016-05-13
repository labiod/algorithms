package com.kgb.sotong;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.*;

/**
 * Created by k.betlej on 2/18/16.
 */
public class SerialDigitPrime {
    static int N;
    static int[] digitDictionary = {1, 2, 3, 5, 7, 9};
    static Boolean[] cache = new Boolean[(int) Math.pow(10, 8)];
    public static void run(Scanner sc) {
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            N = sc.nextInt();
            List<Integer> primeDictionary = new ArrayList<Integer>();
            for(int i = 0; i < N; ++i) {
                List<Integer> newList = new ArrayList<Integer>();
                if(primeDictionary.size() > 0) {
                    for (Integer prime : primeDictionary) {
                        for (int k = 0; k < digitDictionary.length; ++k) {
                            int number = digitDictionary[k];
                            int value = prime * 10 + number;
                            if (isPrimeDigit(value)) {
                                newList.add(value);
                            }
                        }
                    }
                } else {
                    for (int k = 0; k < digitDictionary.length; ++k) {
                        int value = digitDictionary[k];
                        if (isPrimeDigit(value)) {
                            newList.add(value);
                        }
                    }
                }
                primeDictionary = newList;
            }


            for(Integer prime : primeDictionary) {
                System.out.println(prime);
            }

            // Print the answer to standard output(screen).

            System.out.println();
        }
    }

    public static boolean isPrimeDigit(int value) {
        if(cache[value] != null) {
            return cache[value];
        }
        if(value == 1) {
            return false;
        }
        for(int i = 2; i < value; ++i) {
            if(value % i == 0) {
                cache[value] = false;
                return cache[value];
            }
        }
        cache[value] = true;
        return cache[value];
    }
}


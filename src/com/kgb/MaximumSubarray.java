package com.kgb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/20/16.
 */
public class MaximumSubarray {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t2"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int T = sc.nextInt();
        for(int i = 0; i < T; ++i) {
            int N = sc.nextInt();
            int[] table = new int[N];
            for(int k = 0; k < N; ++k) {
                table[k] = sc.nextInt();
            }
            long sum = getMaxSum(table);
            long positiveSum = getPositiveSum(table);
            System.out.println(sum + " " + positiveSum);
        }
    }

    private static long getPositiveSum(int[] table) {
        long sum = 0;
        int item = 0;
        for(int i = 0; i < table.length; ++i) {
            if(table[i] > 0) {
                item++;
                sum += table[i];
            }
        }
        if(item == 0) {
            sum = Integer.MIN_VALUE;
            for(int i = 0 ;i < table.length; ++i) {
                if(table[i] > sum) {
                    sum = table[i];
                }
            }
        }
        return sum;
    }

    private static long getMaxSum(int[] table) {
        long max = Integer.MIN_VALUE;
        long[] cache = new long[table.length];
        long sum = 0;
        for(int i = 0; i < table.length; ++i) {
            if(i-1 > 0) {
                sum = cache[i-1] + table[i];
            } else {
                sum += table[i];
            }
            cache[i] = sum > 0 ? sum : 0;
            if(max < sum) {
                max = sum;
            }
        }
        if(max < 0) {
            for(int i = 0 ;i < table.length; ++i) {
                if(table[i] > max) {
                    max = table[i];
                }
            }
        }
        return max;
    }
}

package com.kgb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/20/16.
 */
public class CoinChange {

    private static long[][] CACHE;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t3"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] coins = new int[M];
        for(int i = 0; i < M; ++i) {
            coins[i] = sc.nextInt();
        }
        if(N == 0 || M == 0) {
            System.out.println(0);
        }
        if(M == 1) {
            System.out.println(N % coins[0] == 0 ? 1 : 0);
        }
        CACHE = new long[N][M];
        long count = findWayCount(coins, M, N);
        System.out.println(count);
    }

    private static long findWayCount(int[] coins, int length, int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        if(length <= 0) {
            return 0;
        }
        if(CACHE[n-1][length-1] != 0) {
            return CACHE[n-1][length-1];
        }
        long sum = findWayCount(coins, length - 1, n) + findWayCount(coins, length, n - coins[length-1]);
        CACHE[n-1][length-1] = sum;
        return sum;
    }
}

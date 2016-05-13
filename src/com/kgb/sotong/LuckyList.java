package com.kgb.sotong;

import com.kgb.RunClass;

import java.util.Scanner;

/**
 * Created by k.betlej on 2/24/16.
 */
public class LuckyList implements RunClass {

    static long cache[][];
    @Override
    public void run(Scanner sc) {
        int T = sc.nextInt();
        for(int tc = 0; tc < T; ++tc) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            cache = new long[N+1][M+1];
            long sum = getLuckyList(N, M, 1);
            System.out.println(sum);
        }
    }

    private static long getLuckyList(int n, int m, int lastNum) {
        long result;
        if(n == 0) {
            return 1;
        }
        if(lastNum > m) {
            return 0;
        }
        if(cache[n][lastNum] != 0) {
            return cache[n][lastNum];
        }
        if(Math.pow(2, n-1) * lastNum > m) {
            return 0;
        } else {
            result = getLuckyList(n-1, m, lastNum*2);
        }
        long partSum = getLuckyList(n, m, lastNum+1);
        result += partSum;
        cache[n][lastNum] = result;
        return result;
    }
}

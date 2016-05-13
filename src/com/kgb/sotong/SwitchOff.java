package com.kgb.sotong;

import com.kgb.RunClass;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by k.betlej on 2/23/16.
 */
public class SwitchOff implements RunClass {

    final static int LEFT = 0;
    final static int RIGHT = 1;
    static int N,S;
    static int Answer;
    static int[][][] cache = new int[1005][1005][2];
    static int[] data = new int[1005];

    @Override
    public void run(Scanner sc) {
        int T = sc.nextInt();
        for(int tc = 0; tc < T; tc++) {
            N = sc.nextInt();
            S = sc.nextInt();
            for(int[][] a: cache) {
                for(int[] b: a) {
                    Arrays.fill(b,  -1);
                }
            }
            for (int i = 1; i <= N; i++) {
                data[i] = sc.nextInt();
            }

            data[N+1] = S;
            Arrays.sort(data, 1, N+2);

            for (int i = 1; i <=N+1; i++) {
                if(data[i]==S){
                    Answer = switchOff(i, i, 1);
                    break;
                }
            }

            // Print the answer to standard output(screen).
            System.out.println(Answer);
        }
    }

    private static int switchOff(int left, int right, int direction) {
        if(right > N && left<=1) {
            return 0;
        }
        if(cache[left][right][direction] >= 0) {
            return cache[left][right][direction];
        }

        int leftSide = Integer.MAX_VALUE;
        int rightSide = Integer.MAX_VALUE;
        int cost = N - (right - left);
        int currentIndex = direction == LEFT ? left : right;
        if(left > 1) {
            leftSide = switchOff(left-1, right, LEFT) + (data[currentIndex] - data[left-1]) * cost;
        }
        if(right <= N ) {
            rightSide = switchOff(left, right+1, RIGHT) + (data[right+1] - data[currentIndex]) * cost;
        }
        int result = Math.min(leftSide, rightSide);
        cache[left][right][direction] = result;
        return result;
    }

}

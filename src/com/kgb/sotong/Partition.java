package com.kgb.sotong;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by k.betlej on 2/18/16.
 */
public class Partition {
    static int N;
    static int [] data = new int[10001];
    static long time;

    public static void run(Scanner sc) throws FileNotFoundException {

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            int i;
            N = sc.nextInt();

            for(i=1; i<=N; i++) {
                data[i] = sc.nextInt();
            }

            /**********************************
             * Implement your algorithm here. *
             **********************************/

            PriorityQueue<Integer> list = new PriorityQueue<Integer>();
            for (int j = 1; j <= N; ++j) {
                list.add(data[j]);
            }

            long counter = 0;
            int currSum;
            while (list.size() > 1) {
                int a = list.remove();
                int b = list.remove();
                currSum = a + b;
                counter += (long)currSum;
                list.add(currSum);
            }
            time = counter;
            // Print the answer to standard output(screen).
            System.out.println(time);
        }
    }
}

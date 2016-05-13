package com.kgb;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/19/16.
 */
public class Djikstria {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("t0"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int TS = sc.nextInt();
        for(int t = 0; t < TS; ++t) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] graph = new int[N][];
            for(int i = 0; i < N; ++i) {
                graph[i] = new int[N];
                for(int j = 0; j < N; ++j) {
                    graph[i][j] = -1;
                }
            }
            for(int i =0; i < M; ++i) {
                int g1 = sc.nextInt();
                int g2 = sc.nextInt();
                int value = sc.nextInt();
                if(graph[g1-1][g2-1] == -1 || graph[g1-1][g2-1] > value) {
                    graph[g1 - 1][g2 - 1] = value;
                }
            }
          int S = sc.nextInt() - 1;

            int[] distance = new int[N];
            List<Integer> stack = new ArrayList<Integer>();
            for(int i = 0; i < distance.length; ++i) {
                distance[i] = graph[S][i];
                if(i != S && distance[i] != -1) {
                    stack.add(i);
                }
            }
            while (!stack.isEmpty()) {
                int index = stack.remove(0);
                for(int i = 0; i < N; ++i) {
                    if(i == index || i == S) {
                        continue;
                    }
                    if(graph[index][i] != -1) {
                        int value = distance[index] + graph[index][i];
                        if(value < distance[i] || distance[i] == -1) {
                            distance[i] = value;
                            if(!stack.contains(i)) {
                                stack.add(i);
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < N; ++i) {
                if(i != S) {
                    System.out.print(distance[i] + " ");
                }
            }
            System.out.println();
        }
    }
}

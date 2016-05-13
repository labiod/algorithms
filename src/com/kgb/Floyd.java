package com.kgb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/19/16.
 */
public class Floyd {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t1"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] graph = new int[N][N];
        for(int i = 0; i < N; ++i) {
            graph[i] = new int[N];
            for(int j = 0; j < N; ++j) {
                graph[i][j] = -1;
                if(i == j) {
                    graph[i][j] = 0;
                }
            }
        }
        for(int i =0; i < M; ++i) {
            int g1 = sc.nextInt() - 1;
            int g2 = sc.nextInt() - 1;
            int value = sc.nextInt();
//            if(graph[g1][g2] == -1 || graph[g1][g2] > value) {
            graph[g1][g2] = value;
//            }
        }
        int Q = sc.nextInt();

        for(int k = 0; k < N; ++k ) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (graph[i][k] == -1 || graph[k][j] == -1) {
                        continue;
                    }
                    if ( graph[i][j] == -1 || graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        for ( int q = 0; q < Q; ++q) {
            int q1 = sc.nextInt() - 1;
            int q2 = sc.nextInt() - 1;
            System.out.println(graph[q1][q2]);
        }
    }
}

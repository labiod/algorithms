package com.kgb;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/19/16.
 */
public class Prim_Kruskal {
    private static class Edge implements Comparable<Edge> {
        int mN1;
        int mN2;
        int mValue;

        public Edge(int n1, int n2, int value) {
            mN1 = n1;
            mN2 = n2;
            mValue = value;
        }

        @Override
        public int compareTo(Edge o) {
            return mValue < o.mValue ? -1 : mValue > o.mValue ? 1 : 0;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "mValue=" + mValue +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("t3"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Edge> edges = new ArrayList<Edge>(M);
        for (int i = 0; i < M; ++i) {
            int g1 = sc.nextInt();
            int g2 = sc.nextInt();
            int value = sc.nextInt();
            edges.add(new Edge(g1 - 1, g2 - 1, value));
        }
        Collections.sort(edges);
        int[] groups = new int[N];
        int[] groupCount = new int[N];
        for(int i = 0; i < N; ++i) {
            groups[i] = i;
            groupCount[i] = 1;
        }
        int sum = 0;
        for(Edge edge : edges) {
            if(groups[edge.mN1] != groups[edge.mN2]) {
                if(groupCount[groups[edge.mN1]] >= groupCount[groups[edge.mN2]]) {
                    int k = 0;
                    int oldGroup = groups[edge.mN2];
                    while(groupCount[oldGroup] > 0){
                        if(groups[k] == oldGroup) {
                            groupCount[oldGroup]--;
                            groups[k] = groups[edge.mN1];
                            groupCount[groups[edge.mN1]]++;
                        }
                        k++;
                    }

                } else {
                    int k = 0;
                    int oldGroup = groups[edge.mN1];
                    while(groupCount[oldGroup] > 0){
                        if(groups[k] == oldGroup) {
                            groupCount[oldGroup]--;
                            groups[k] = groups[edge.mN2];
                            groupCount[groups[edge.mN2]]++;
                        }
                        k++;
                    }
                }
                sum += edge.mValue;
            }
        }

        System.out.println(sum);
    }
}

package com.kgb;

import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 9/16/15.
 */
public class KruskalMST {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            Scanner scanner = new Scanner(new FileInputStream("ex2.txt"));
            int ts = scanner.nextInt();
            for(int i =0; i < ts; ++i) {
                int nodeLength = scanner.nextInt();
                int endgesNumber = scanner.nextInt();
                int[][] nodes = new int[nodeLength][nodeLength];
                int[] visited = new int[nodeLength];
                for(int k = 0; k < nodeLength; ++k) {
                    visited[k] = -1;
                }
                for(int j =0; j < endgesNumber; ++j) {
                    int x = scanner.nextInt() - 1;
                    int y = scanner.nextInt() - 1;

                    int r = scanner.nextInt();
                    if(nodes[x][y] > 0) {
                        nodes[x][y] = Math.min(nodes[x][y], r);
                        nodes[y][x] = Math.min(nodes[y][x], r);
                    } else {
                        nodes[x][y] = r;
                        nodes[y][x] = r;
                    }
                }
                int startNode = scanner.nextInt() - 1;
                visited[startNode] = 0;
                List<Integer> list = new ArrayList<Integer>();
                list.add(startNode);
                int treeWieght = 0;
                List<Pair<Integer, Integer>> sortedEdges = new ArrayList<Pair<Integer, Integer>>();
                for(int j = 0; j < nodeLength; ++j) {

                }
                while (list.size() > 0) {
                    int v = list.remove(0);
                    for(int k =0; k < nodeLength; ++k) {
                        if((nodes[v][k] > 0) && (visited[k] == -1 || visited[k] > visited[v] + nodes[v][k])) {
                            list.add(k);
                            visited[k] = visited[v] + nodes[v][k];
                        }
                    }
                }
                for(int k = 0; k < nodeLength; ++k) {
                    if(k != startNode) {
                        System.out.print(visited[k] + " ");
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

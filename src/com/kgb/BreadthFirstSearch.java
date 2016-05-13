package com.kgb;

import com.kgb.collections.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by k.betlej on 9/16/15.
 */
public class BreadthFirstSearch {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            Scanner scanner = new Scanner(new FileInputStream("ex1.txt"));
            int ts = scanner.nextInt();
            for(int i =0; i < ts; ++i) {
                int nodesLength = scanner.nextInt();
                int edgesLength = scanner.nextInt();
                int roadLength = 6;
                int visited[] = new int[nodesLength];
                for(int k = 0; k < nodesLength; ++k) {
                    visited[k] = -1;
                }
                boolean[][] nodes = new boolean[nodesLength][nodesLength];
                for(int m = 0; m < edgesLength; ++m) {
                    int x = scanner.nextInt() - 1;
                    int y = scanner.nextInt() - 1;
                    nodes[x][y] = true;
                    nodes[y][x] = true;
                }
                int startNode = scanner.nextInt() - 1;
                List<Integer> list = new List<Integer>();
                list.add(startNode);
                visited[startNode] = 0;
                while(list.size() > 0) {
                    int v = list.get(0);
                    list.remove(0);
                    for(int j = 0; j < nodes.length; ++j) {
                       if(nodes[v][j] && visited[j] == -1) {
                           list.add(j);
                           visited[j] = visited[v] + 6;
                       }
                    }
                }
                for(int k = 0; k < nodesLength; ++k) {
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

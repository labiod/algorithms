package com.kgb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/20/16.
 */
public class Clique {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("tt1"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int T = sc.nextInt();
        for(int ts = 0; ts < T; ++ts) {
            if(!sc.hasNextInt()) {
                continue;
            }
            int N = sc.nextInt();
            if(!sc.hasNextInt()) {
                continue;
            }
            int M = sc.nextInt();
            for(int k = N; k > 0; --k) {
                int v = ((k - 2)*N*N)/(2*(k-1));
                if(v < M) {
                    System.out.println(k);
                    break;
                }
            }

        }
    }
}

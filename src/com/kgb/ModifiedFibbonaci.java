package com.kgb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by k.betlej on 1/20/16.
 */
public class ModifiedFibbonaci {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t1"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));

        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        BigInteger last = BigInteger.valueOf(A);
        BigInteger current = BigInteger.valueOf(B);
        for(int i = 2; i < N; ++i) {
            BigInteger tmp = current;
            current = current.pow(2).add(last);
            last = tmp;
        }
        System.out.println(current);
    }
}

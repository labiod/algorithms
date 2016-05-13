package com.kgb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by k.betlej on 9/17/15.
 */
public class Lasers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("ext4.txt"));
        int tc = sc.nextInt();
        for(int i =0; i < tc; ++i) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] bitSetList = new int[n];
            for(int j = 0; j < n; ++j) {
                int bitSet = 0;
                for(int s = 0; s < m; ++s) {

                    int bit = sc.nextInt();
                    bitSet |= bit*(int)Math.pow(2, m-1-s);
                }
                bitSetList[j] = bitSet;
            }
//            Solution.printTable(bitSetList);
            startLaser(bitSetList, m, 0);
//            Solution.printTable(bitSetList);
        }
    }

    private static void startLaser(int[] bitSetList, int setSize, int i) {
        int column = setSize - 1 - i;
        for(int bitSet : bitSetList) {
            int t = bitSet ^ (1 << column);
        }
    }
}

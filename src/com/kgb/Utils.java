package com.kgb;

/**
 * Created by k.betlej on 11/10/15.
 */
public class Utils {

    public static void printTable(int[] table) {
        System.out.print("[ ");
        for(int i =0; i < table.length; ++i) {
            System.out.print(table[i] + " ");
        }
        System.out.println("]");
    }
}

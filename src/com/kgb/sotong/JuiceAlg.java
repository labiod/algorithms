package com.kgb.sotong;

import com.kgb.RunClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by k.betlej on 2/25/16.
 */
public class JuiceAlg implements RunClass {

    static class Juice implements Comparable<Juice> {
        int cost;
        int weight;

        public Juice(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }


        @Override
        public int compareTo(Juice o) {
            double value = (double)weight / cost;
            double value2 = (double)o.weight / o.cost;
            return (int)(value2*10 - value*10);
        }

        @Override
        public String toString() {
            return " weight: " + weight + ", cost: " + cost;
        }
    }

    static int[][] cache;

    @Override
    public void run(Scanner sc) {
        int T = sc.nextInt();
        for(int tc = 0; tc < T; tc++) {

            /**********************************
             *  Implement your algorithm here. *
             ***********************************/
            int emptyCupWeight = sc.nextInt();
            int fullCupWeight = sc.nextInt();
            int maxJuiceWeight = fullCupWeight - emptyCupWeight;
            int N = sc.nextInt();
            cache = new int[N][maxJuiceWeight];
            List<Juice> juiceList = new ArrayList<Juice>();
            for(int i = 0; i < N; ++i) {

                Juice juice = new Juice(sc.nextInt(), sc.nextInt());
                if(juice.weight <= maxJuiceWeight) {
                    juiceList.add(juice);
                }
            }
            Collections.sort(juiceList);
            System.out.println(juiceList);
//            System.out.println(maxJuiceWeight);
            long juiceCost = getMinimalCost(juiceList, maxJuiceWeight);
            // Print the answer to standard output(screen).
            if(juiceCost != Integer.MAX_VALUE) {
                System.out.println(juiceCost);
            } else {
                System.out.println("impossible");
            }

        }
    }

    private static int getMinimalCost(List<Juice> juices, int juiceWeight) {
        int juiceCost = Integer.MAX_VALUE;
        for(int i = 0; i < juices.size(); ++i) {
            for(int j =0; j < juiceWeight; ++j) {

            }
        }
        return juiceCost;
    }

    private static int getMinimalCost2(List<Juice> juices, int juiceWeight) {
        int juiceCost = 0;
        int[][][] optimas = new int[juices.size()][][];
        for(int i = 0; i < juices.size(); ++i) {
            optimas[i] = new int[juiceWeight][];
            for(int weight = 0; weight < juiceWeight; ++weight) {
                optimas[i][weight] = new int[2];
                int currWeight = weight + 1;
                if(juices.get(i).weight <= currWeight) {

                    optimas[i][weight][0] = juices.get(i).cost * (currWeight / juices.get(i).weight);
                    optimas[i][weight][1] = juices.get(i).weight * (currWeight / juices.get(i).weight);
                    if(i > 0 && optimas[i][weight][1] != currWeight) {
                        optimas[i][weight][0] = Math.min(optimas[i - 1][weight][0], optimas[i][weight][0]);
                        optimas[i][weight][1] = optimas[i - 1][weight][1];
                    }
                } else {
                    if(i > 0) {
                        optimas[i][weight][0] = Math.min(optimas[i - 1][weight][0], Integer.MAX_VALUE);
                    } else {
                        optimas[i][weight][0] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        juiceCost = optimas[juices.size() - 1][juiceWeight - 1][1] == juiceWeight ? optimas[juices.size() - 1][juiceWeight - 1][0] : 0;
        return juiceCost;
    }
}

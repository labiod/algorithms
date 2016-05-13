package com.kgb.sotong;


import com.kgb.RunClass;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by k.betlej on 2/22/16.
 */
public class AmendingACowshed implements RunClass {
    static class Gaps {
        private int mStart;
        private int mEnd;

        public Gaps(int start, int end) {

            mStart = start;
            mEnd =end;
        }

        public int gapSize() {
            return mEnd - mStart + 1;
        }

        @Override
        public String toString() {
            return mStart + " :" + mEnd;
        }
    }
    static int M,N,C;
    static int [] data = new int[205];
    static int Answer;

    @Override
    public void run(Scanner sc) {
        int T = sc.nextInt();
        for(int tc = 0; tc < T; tc++) {
            M = sc.nextInt();
            N = sc.nextInt();
            C = sc.nextInt();
            Gaps[] gaps = new Gaps[M-1];
            for(int i=1;i<=C;i++) {
                data[i] = sc.nextInt();
            }
            Arrays.sort(data, 1, C+1);
            for(int i=1;i<=C;i++)
            {
                if(i > 1) {
                    Gaps newGap = new Gaps(data[i -1] + 1, data[i] - 1);
                    for (int g = 0; g < M-1; ++g) {
                        if(gaps[g] == null) {
                            gaps[g] = newGap;
                            break;
                        }
                        if (newGap.gapSize() > gaps[g].gapSize()) {
                            Gaps tmp = gaps[g];
                            gaps[g] = newGap;
                            newGap = tmp;
                        }
                    }
                }
            }

            /**********************************
             *  Implement your algorithm here. *
             ***********************************/
            Answer = 0;
            for(int g = 0; g < M-1; ++g) {
                if(gaps[g] != null) {
                    Answer += gaps[g].gapSize();
                }
            }
            Answer = N - (N - (data[C])) - (data[1] - 1) - Answer;
            // Print the answer to standard output(screen).
            System.out.println(Answer);
        }
    }
}


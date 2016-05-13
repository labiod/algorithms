package com.kgb.sotong;

import com.kgb.RunClass;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

class Spot implements Comparable<Spot> {
    int x =0;
    int y = 0;

    @Override
    public int compareTo(Spot p) {
        if (this.x == p.x) {
            return this.y - p.y;
        } else {
            return this.x - p.x;
        }
    }

    public String toString() {
        return "("+x + "," + y+")";
    }
}

public class AreaOfTerritory implements RunClass {
    static int N;
    static Spot [] data = new Spot[105];
    static double Answer;
    final static int MINX = 0;
    final static int MINY = 1;
    final static int MAXX = 2;
    final static int MAXY = 3;

    @Override
    public void run(Scanner sc) {
        int T = sc.nextInt();
        for(int tc = 0; tc < T; tc++) {
            N = sc.nextInt();
            int topSpotIndex = 0;
            for(int i=1;i<=N;i++)
            {
                data[i] = new Spot();
                data[i].x = sc.nextInt();
                data[i].y = sc.nextInt();

                if(topSpotIndex == 0) {
                    topSpotIndex = i;
                } else {
                    if(data[i].x < data[topSpotIndex].x) {
                        topSpotIndex = i;
                    }
                }
            }
            /**********************************
             *  Implement your algorithm here. *
             ***********************************/
            Spot[] hull = getSpots(data, N);

            Answer = calculateSize(hull);
            // Print the answer to standard output(screen).
            DecimalFormat t = new DecimalFormat("0.00");
            System.out.println(t.format(Answer));
        }
    }

    private double calculateSize(Spot[] hull) {
        double result = 0.0;
        int minXIndex = 0;
        int maxXIndex = minXIndex;
        int maxYIndex = hull.length - 1;
        int minYIndex = maxYIndex;
        for (int i = 0; i < hull.length; i++) {
            if(hull[i].x > hull[maxXIndex].x) {
                maxXIndex = i;
            }
            if(hull[i].y < hull[minYIndex].y) {
                minYIndex = i;
            } else if(hull[i].y > hull[maxYIndex].y) {
                maxYIndex = i;
            }
        }
        int currBorderSpot = MINX;
        for(int i = 0; i < hull.length; ++i) {
            int nextIndex = i+1 >= hull.length ? 0 : i+1;
            double area = (double) (Math.abs(hull[nextIndex].x - hull[i].x) * Math.abs(hull[i].y - hull[nextIndex].y)) / 2;
            result += area;
            int x = 0;
            int y = 0;
            switch (currBorderSpot) {
                case MINX:
                    if(nextIndex == minYIndex) {
                        currBorderSpot++;
                        continue;
                    } else {
                        x = Math.abs(hull[i].x - hull[nextIndex].x);
                        y = Math.abs(hull[minYIndex].y - hull[nextIndex].y);
                    }
                    break;
                case MINY:
                    if(nextIndex == maxXIndex) {
                        currBorderSpot++;
                        continue;
                    } else {
                        y = Math.abs(hull[i].y - hull[nextIndex].y);
                        x = Math.abs(hull[maxXIndex].x - hull[nextIndex].x);
                    }
                    break;
                case MAXX:
                    if(nextIndex == maxYIndex) {
                        currBorderSpot++;
                        continue;
                    } else {
                        x = Math.abs(hull[i].x - hull[nextIndex].x);
                        y = Math.abs(hull[maxYIndex].y - hull[nextIndex].y);
                    }
                    break;
                case MAXY:
                    if(nextIndex == minXIndex) {
                        currBorderSpot++;
                        continue;
                    } else {
                        y = Math.abs(hull[i].y - hull[nextIndex].y);
                        x = Math.abs(hull[minXIndex].x - hull[nextIndex].x);
                    }
                    break;
            }
            result += x * y;
        }

        result = (hull[maxXIndex].x - hull[minXIndex].x) * (hull[maxYIndex].y - hull[minYIndex].y) - result;
        return result;
    }

    private Spot[] getSpots(Spot[] P, int N) {
        if (N > 1) {
            int k = 0;
            Spot[] H = new Spot[2 * N];

            Arrays.sort(P, 1, N+1);
            System.out.println();
            // Build lower hull
            for (int i = 1; i <= N; ++i) {
                while (k >= 2 && cross(H[k - 2], H[k - 1], P[i]) <= 0)
                    k--;
                H[k++] = P[i];
            }

            // Build upper hull
            for (int i = N - 1, t = k + 1; i > 0; i--) {
                while (k >= t && cross(H[k - 2], H[k - 1], P[i]) <= 0)
                    k--;
                H[k++] = P[i];
            }
            if (k > 1) {
                H = Arrays.copyOfRange(H, 0, k - 1);
            }
            return H;
        } else if (N <= 1) {
            return P;
        } else{
            return null;
        }
    }

    private static long cross(Spot O, Spot A, Spot B) {
        return (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
    }
}

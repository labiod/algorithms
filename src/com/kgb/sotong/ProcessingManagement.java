package com.kgb.sotong;

import java.util.*;

/**
 * Created by k.betlej on 2/18/16.
 */
public class ProcessingManagement {
    static class Steel implements Comparable<Steel> {

        private final int mWidth;
        private final int mHeight;

        public Steel(int width, int height) {
            mWidth = width;
            mHeight = height;
        }

        @Override
        public int compareTo(Steel o) {
            int difW = mWidth - o.mWidth;
            int difH = mHeight - o.mHeight;

            if(difW < 0) {
                return -1;
            } else if(difW == 0) {
                return difH;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "width:" + mWidth + ", height:" + mHeight;
        }
    }
    public static void run(Scanner sc) {
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            int N = sc.nextInt();
            List<Steel> queue = new ArrayList<Steel>();
            for(int i = 0; i < N; ++i) {
                int w = sc.nextInt();
                int h = sc.nextInt();
                queue.add(new Steel(w, h));
            }
            Collections.sort(queue);
            int count = 1;
            Steel lastItem = queue.remove(0);
            int index = 0;
            while(!queue.isEmpty()) {
                if(index >= queue.size()) {
                    index = 0;
                    count++;
                    lastItem = queue.remove(0);
                    continue;
                }
                Steel currItem = queue.get(index);
                if(lastItem.mWidth <= currItem.mWidth && lastItem.mHeight <= currItem.mHeight) {
                    lastItem = currItem;
                    queue.remove(index);
                } else {
                    index++;
                }
            }
            System.out.println(count);
        }
    }
}

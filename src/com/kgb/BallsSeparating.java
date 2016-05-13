package com.kgb;

/**
 * Created by k.betlej on 9/28/15.
 */
public class BallsSeparating {
    private static final int RED_TABLE = 0;
    private static final int GREEN_TABLE = 1;
    private static final int BLUE_TABLE = 2;

    private static int[] operationNumbers;

    public static int minOperations(int[] red, int[] green, int[] blue) {
        operationNumbers = new int[red.length];
        if(red.length == 1) {
            return -1;
        }
        int[][] boxes = new int[3][];
        boxes[RED_TABLE] = red;
        boxes[GREEN_TABLE] = green;
        boxes[BLUE_TABLE] = blue;
        int operationNumber = getOperationCount(boxes);

        return operationNumber;
    }

    private static  int getOperationCount(int[][] boxes) {
        return 0;
    }

    private static int[] findBestWay(int[][] boxes, int length) {
        int[] result;
        if(length == 3) {
            result = new int[4];
            result[RED_TABLE] = -1;
            result[GREEN_TABLE] = -1;
            result[BLUE_TABLE] = -1;
            int operationCount = Integer.MAX_VALUE;
            for(int i =0; i < 3; ++i) {
                int redChoose = boxes[GREEN_TABLE][i] + boxes[BLUE_TABLE][i];
                int greenChoose = boxes[RED_TABLE][i] + boxes[BLUE_TABLE][i];
                int blueChoose = boxes[RED_TABLE][i] + boxes[GREEN_TABLE][i];
                int minFromTable = getMinTableChoose(redChoose, greenChoose, blueChoose);
                result[minFromTable] = i;
            }
        } else {
            result = findBestWay(boxes, length - 1);
        }
        return result;
    }

    private static int getMinTableChoose(int redChoose, int greenChoose, int blueChoose) {
        if(redChoose > greenChoose) {
            if(redChoose > blueChoose) {
                return  RED_TABLE;
            } else {
                return BLUE_TABLE;
            }
        } else if (greenChoose > blueChoose) {
            return GREEN_TABLE;
        } else {
            return BLUE_TABLE;
        }
    }

    public static void sortBoxes(int[][] boxes) {

    }
}

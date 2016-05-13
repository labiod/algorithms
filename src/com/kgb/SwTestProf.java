package com.kgb;

import java.util.Scanner;

/**
 * Created by k.betlej on 2/29/16.
 */
public class SwTestProf implements RunClass {
    static int LC;
    static int K;
    @Override
    public void run(Scanner sc) {
        int T = sc.nextInt();
        for(int tc = 0; tc < T; ++tc) {
            int N = sc.nextInt();
            LC = sc.nextInt();
            K = sc.nextInt();
            String types = sc.next();
            int cost = getRecordingCost(types, N);
            System.out.println(cost);
        }
    }

    private int getRecordingCost(String types, int recordLength) {
        if(recordLength == 1) {
            return LC + K*types.length();
        }

        int cost = getRecordingCost(types, recordLength-1);
        String typeToRecord = getTypeToRecord(types, recordLength, 0, '*');
        if(typeToRecord == null) {
            return cost;
        }
        System.out.println(typeToRecord);
        int deviceRecordCount = getRecordCount(typeToRecord, recordLength);
        int currCost = LC * recordLength + K * deviceRecordCount;
        return Math.min(currCost, cost);
    }

    private int getRecordCount(String typeToRecord, int recordLength) {
        int index = 0;
        int result = 0;
        int count = 1;
        char lastChar = typeToRecord.charAt(index++);
        while(index < typeToRecord.length()) {
            char type = typeToRecord.charAt(index++);
            if(lastChar == type) {
                count++;
            } else {
                if(count > 0) {
                    result++;
                }
                count = 1;
                lastChar = type;
            }
            if(count == recordLength) {
                result++;
                count=0;
            }
        }
        if(count > 0) {
            result++;
        }
        return result;
    }

    private String getTypeToRecord(String types, int recordLength, int index, char lastType) {
        if(index >= types.length()) {
            return types;
        }
        char filledLetter = types.charAt(index++);
        int count = 1;
        int replaceCount = 0;
        while (filledLetter == '*') {
            replaceCount++;
            if(index >= types.length()) {
                break;
            }
            filledLetter = types.charAt(index++);
            count++;
        }
        if(filledLetter == '*') {
            filledLetter = lastType;
        }
        if(lastType == filledLetter) {
            count = recordLength;
        }
        String result = types;
        if(count < recordLength) {
            if(index >= types.length()) {
                return null;
            }
            char currType = result.charAt(index);
            while(currType == '*' || currType == filledLetter) {
                if(count == recordLength) {
                    break;
                }
                if(currType == '*') {
                    replaceCount++;
                }
                if(index+1 >= types.length()) {
                    break;
                }
                currType = result.charAt(++index);
                count++;
            }
        }
        if(count < recordLength) {
            return null;
        }
        for(int i = 0; i < replaceCount; ++i) {
            result = result.replaceFirst("\\*", String.valueOf(filledLetter));
        }
        String res = getTypeToRecord(result, recordLength, index, filledLetter);
        return res;
    }
}

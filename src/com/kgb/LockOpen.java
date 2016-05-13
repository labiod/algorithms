package com.kgb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 11/10/15.
 */
public class LockOpen {

    public static void unlock() throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new FileInputStream("t0"));
        while(true) {
            int startPos = scanner.nextInt();
            int firstPos = scanner.nextInt();
            int secondPos = scanner.nextInt();
            int thirdPos = scanner.nextInt();
            if(startPos == 0 && firstPos == 0 && secondPos == 0 && thirdPos == 0) {
                break;
            }
            int valueModifier = 9;
            int startValue = 1080;
            if(startPos > firstPos) {
                startValue += (startPos - firstPos) * valueModifier;
            } else if(startPos < firstPos) {
                startValue += (360 - firstPos * valueModifier) + startPos * valueModifier;
            }
            if(firstPos < secondPos) {
                startValue += (secondPos - firstPos) * valueModifier;
            } else if(firstPos > secondPos) {
                startValue += (360 - firstPos * valueModifier) + secondPos * valueModifier;
            }
            if(secondPos > thirdPos) {
                startValue += (secondPos - thirdPos) * valueModifier;
            } else if(secondPos < thirdPos) {
                startValue += (360 - thirdPos * valueModifier) + secondPos * valueModifier;
            }

            System.out.println(startValue);
        }
    }
}

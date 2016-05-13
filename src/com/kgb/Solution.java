package com.kgb;
import com.kgb.sotong.*;

import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("sample_input"));
        RunClass runClass = new SwTestProf();
        runClass.run(sc);
    }
}

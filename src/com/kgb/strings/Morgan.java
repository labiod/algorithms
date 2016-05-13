package com.kgb.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by k.betlej on 2/18/16.
 */
public class Morgan {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("t11"));
//        System.setOut(new PrintStream(new FileOutputStream("dupa")));
        int T = sc.nextInt();
        for(int ts = 0; ts < T; ++ts) {
            String text1 = sc.next();
            String text2 = sc.next();
            String result = getBestString2(text1, text2);
            System.out.println(result);
        }
    }

    private static String getBestString(String text1, String text2) {
        String result = "";
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < text1.length() && ptr2 < text2.length()) {
            char c1 = text1.charAt(ptr1);
            char c2 = text2.charAt(ptr2);
            if(c1 < c2 ) {
                result += c1;
                ptr1++;
            } else if(c2 < c1) {
                result += c2;
                ptr2++;
            } else {
                String s = String.valueOf(c1);
                int i1 = ptr1;
                int i2 = ptr2;
                char s1 = c1;
                char s2 = c2;
                i1++;
                i2++;
                while (i1 < text1.length() && i2 < text2.length()) {
                    s1 = text1.charAt(i1);
                    s2 = text2.charAt(i2);
                    if(s1 == s2 && c1 >= s1) {
                        s += s1;
                    } else {
                        break;
                    }
                    i1++;
                    i2++;
                }
                if(s1 == s2) {
                    s += s;
                    if(i1 >= text1.length() || i2 >= text2.length()) {
                        ptr1 = i1;
                        ptr2 = i2;
                    } else {
                        ptr1 = i1;
                        ptr2 = i2;
                    }

                } else if(s1 < s2) {
                    s += s1;
                    ptr1 = i1 + 1;
                } else {
                    s += s2;
                    ptr2 = i2 + 1;
                }
                result += s;
            }
        }
        if(ptr1 >= text1.length()) {
            result += text2.substring(ptr2);
        } else if(ptr2 >= text2.length()){
            result += text1.substring(ptr1);
        }

        return result;
    }

    private static String getBestString2(String text1, String text2) {
        StringBuilder result = new StringBuilder();
        int ptr1 = 0;
        int ptr2 = 0;
        StringBuilder tmp = new StringBuilder();
        while(ptr1 < text1.length() && ptr2 < text2.length()) {
            char c1 = text1.charAt(ptr1);
            char c2 = text2.charAt(ptr2);
            if(c1 < c2) {
                if(tmp.length() > 0) {
                    if(c1 < tmp.charAt(0)) {
                        result.append(tmp).append(c1);
                        ptr2 -= tmp.length();
                        tmp = new StringBuilder();
                        ptr1++;
                    } else if(c1 == tmp.charAt(0)) {
//                        if(ptr1 == text1.length() - 1) {
                        result.append(tmp);
                        ptr2 -= tmp.length();
                        tmp = new StringBuilder();
//                        }
                    } else {
                        tmp.append(tmp);
                        result.append(tmp);
                        tmp = new StringBuilder();
                        result.append(c1);
                        ptr1++;
                    }
                } else {
                    result.append(c1);
                    ptr1++;
                }


            } else if(c2 < c1) {
                if(tmp.length() > 0) {
                    if(c2 < tmp.charAt(0)) {
                        result.append(tmp).append(c2);
                        ptr1 -= tmp.length();
                        tmp = new StringBuilder();
                        ptr2++;
                    } else if(c2 == tmp.charAt(0)) {
//                        if(ptr2 == text1.length() - 1) {
                        result.append(tmp);
                        ptr1 -= tmp.length();
                        tmp = new StringBuilder();
//                        }

                    } else {
                        tmp.append(tmp);
                        result.append(tmp);
                        tmp = new StringBuilder();
                        result.append(c2);
                        ptr2++;
                    }
                } else {
                    result.append(c2);
                    ptr2++;
                }
            } else {
                if(ptr1 == text1.length() - 1 && ptr2 == text2.length() - 1) {
                    if(tmp.length() > 0 && c1 < tmp.charAt(0)) {
                        tmp.append(c1);
                        tmp.append(tmp);
                    } else {
                        tmp.append(tmp);
                        tmp.append(c1);
                        tmp.append(c1);
                    }
                    result.append(tmp);
                    tmp = new StringBuilder();
                    ptr1++;
                    ptr2++;
                } else if(ptr1 == text1.length() - 1) {
                    if(tmp.length() > 0) {
                        ptr1 -= tmp.length();
                        tmp.append(c2);
                        result.append(tmp);

                        ptr2++;
                        tmp = new StringBuilder();
                    } else {
                        result.append(c2);
                        ptr2++;
                    }
                } else if(ptr2 == text2.length() - 1) {
                    if(tmp.length() > 0) {
                        ptr2 -= tmp.length();
                        tmp.append(c1);
                        result.append(tmp);

                        ptr1++;
                        tmp = new StringBuilder();
                    } else {
                        result.append(c1);
                        ptr1++;
                    }
                } else {
                    if (tmp.length() > 0) {
                        if (tmp.charAt(0) < c1) {
                            tmp.append(tmp);
                            result.append(tmp);
                            tmp = new StringBuilder();
                        } else if(tmp.charAt(0) == c1 && tmp.length() > 1) {
                            char s1 =text1.charAt(ptr1 + 1);
                            char s2 =text2.charAt(ptr2 + 1);
                            if(s1 == s2 && s1 > tmp.charAt(1)) {
                                tmp.append(tmp);
                                result.append(tmp);
                                tmp = new StringBuilder();
                            } else if(s1 == s2 && s1 == tmp.charAt(1)) {
                                ptr1 -= tmp.length();
                                result.append(tmp);
                                tmp = new StringBuilder();
                            } else {
                                tmp.append(c1);
                                ptr1++;
                                ptr2++;
                            }
                        } else {
                            tmp.append(c1);
                            ptr1++;
                            ptr2++;
                        }
                    } else {
                        tmp.append(c1);
                        ptr1++;
                        ptr2++;
                    }
                }
            }
        }
        if(tmp.length() > 0) {
            tmp.append(tmp);
            result.append(tmp);
        }
        if(ptr1 >= text1.length()) {
            result.append(text2.substring(ptr2));
        } else if(ptr2 >= text2.length()){
            result.append(text1.substring(ptr1));
        }

        return result.toString();
    }

    private static String getBestString3(String text1, String text2) {
        StringBuilder result = new StringBuilder();
        int ptr1 = 0;
        int ptr2 = 0;
        StringBuilder tmp = new StringBuilder();
        while(ptr1 < text1.length() && ptr2 < text2.length()) {
            char c1 = text1.charAt(ptr1);
            char c2 = text2.charAt(ptr2);
            if(c1 < c2) {
                if(tmp.length() > 0) {
                    if(tmp.charAt(0) < c1) {
                        result.append(tmp).append(c1);
                        ptr1++;
                    } else {
                        ptr2 -= tmp.length();
                        tmp = new StringBuilder();
                    }
                } else {
                    result.append(c1);
                    ptr1++;
                }

            } else if(c2 < c1) {
                if(tmp.length() > 0) {
                    if(tmp.charAt(0) < c2) {
                        result.append(tmp).append(c2);
                        ptr2++;
                    } else {
                        ptr1 -= tmp.length();
                        tmp = new StringBuilder();
                    }
                } else {
                    result.append(c2);
                    ptr2++;
                }
            } else {

            }
        }
        if(ptr1 < text1.length()) {
            result.append(text1.substring(ptr1));
        } else if(ptr2 < text2.length()) {
            result.append(text2.substring(ptr2));
        }
        return result.toString();
    }
}

package com.kgb.collections.sort;

import com.kgb.collections.Collection;

/**
 * Created by k.betlej on 8/10/15.
 */
public class Sorting {
    public static void bubleSort(int[] table) {
        for(int i =0; i < table.length; ++i) {
            for(int j = table.length - 1; j > i; --j) {
                if(table[i] > table[j]) {
                    int tmp = table[i];
                    table[i] = table[j];
                    table[j] = tmp;
                }
            }
        }
    }

    public static void insertionSort(int[] table) {
        int startTableIndex = table.length - 1;
        for(int i =table.length - 2; i >= 0; --i) {
            int changesIndex = i;
            for(int j = startTableIndex; j < table.length; ++j) {
                if(table[changesIndex] > table[j]) {
                    int tmp = table[changesIndex];
                    table[changesIndex] = table[j];
                    table[j] = tmp;
                    changesIndex = j;
                } else {
                    break;
                }
            }
            startTableIndex = i;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] table) {
        int startTableIndex = table.length - 1;
        for(int i =table.length - 2; i >= 0; --i) {
            int changesIndex = i;
            for(int j = startTableIndex; j < table.length; ++j) {
                if(table[changesIndex].compareTo(table[j]) == 1) {
                    T tmp = table[changesIndex];
                    table[changesIndex] = table[j];
                    table[j] = tmp;
                    changesIndex = j;
                } else {
                    break;
                }
            }
            startTableIndex = i;
        }
    }

    public static void labSort(int[] table) {

        for(int i =0; i < table.length / 2; ++i) {
            int sIdx = i;
            int eIdx = table.length - 1 - i;
            int min = sIdx;
            int max = eIdx;
            while(sIdx <= eIdx) {
                if(table[sIdx] > table[eIdx]) {
                    int tmp = table[sIdx];
                    table[sIdx] = table[eIdx];
                    table[eIdx] = tmp;
                }
                if(table[sIdx] < table[min]) {
                    min = sIdx;
                }
                if(table[eIdx] > table[max]) {
                    max = eIdx;
                }
                sIdx++;
                eIdx--;
            }

            int tmp = table[i];
            table[i] = table[min];
            table[min] = tmp;

            tmp = table[table.length - 1 - i];
            table[table.length - 1 - i] = table[max];
            table[max] = tmp;
        }

    }

    public static void quickSort(int[] table) {
        internalQuickSort(table, 0, table.length - 1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] table) {
        internalQuickSort(table, 0, table.length - 1);
    }

    private static <T extends Comparable<T>> void internalQuickSort(T[] table, int startIndex, int endIndex) {
        T pivotValue = table[(startIndex + endIndex) / 2];
        int i = startIndex;
        int j = endIndex;
        while(i < j) {
            while(table[i].compareTo(pivotValue) == -1) {
                ++i;
            }
            while (table[j].compareTo(pivotValue) == 1) {
                --j;
            }
            if(i <= j) {
                T tmp = table[i];
                table[i] = table[j];
                table[j] = tmp;
                ++i;
                --j;
            }
        }
        if(j > startIndex) {
            internalQuickSort(table, startIndex, j);
        }
        if(i < endIndex) {
            internalQuickSort(table, i, endIndex);
        }
    }

    private static void internalQuickSort(int[] table, int startIndex, int endIndex) {
        int pivotValue = table[(startIndex + endIndex) / 2];
        int i = startIndex;
        int j = endIndex;
        while(i < j) {
            while(table[i] < pivotValue) {
                ++i;
            }
            while (table[j] > pivotValue) {
                --j;
            }
            if(i <= j) {
                int tmp = table[i];
                table[i] = table[j];
                table[j] = tmp;
                ++i;
                --j;
            }
        }
        if(j > startIndex) {
            internalQuickSort(table, startIndex, j);
        }
        if(i < endIndex) {
            internalQuickSort(table, i, endIndex);
        }
    }


}

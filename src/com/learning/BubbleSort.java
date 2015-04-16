package com.learning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BubbleSort {

    public static void main(String arg[]) {

        int[] test1 = { 3, 2, 21, 6, 15, 20 };
        // bubbleSort(test1);
        System.out.println(int[].class);
        System.out.println(Integer[].class);
        System.out.println(double[].class);
        System.out.println(long[].class);
        System.out.println(Object[].class);
        System.out.println(String[].class);
        String[] strings = new String[2];
        System.out.println(strings instanceof Object[]);
        bubleSort(test1);
        printArray(test1);

    }


    public static void bubbleSort(int input[]) {
        int lenght = input.length - 1;
        boolean isChanged = false;
        for (int i = 0; i < lenght; i++) {
            // keep = input[0];
            isChanged = false;
            for (int j = 1; j < lenght - i; j++) {
                if (input[j - 1] > input[j]) {
                    int tmp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = tmp;
                    isChanged = true;
                }
            }
            if (!isChanged) {
                break;
            }
        }
        printArray(input);
    }

    // 2013.3.31
    public static void bubleSort(int input[]) {
        int length = input.length;
        for (int i = 0; i < length; i++) {
            boolean isChanged = false;
            int tmp;
            for (int j = 0; j < length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    tmp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = tmp;
                    isChanged = true;
                }
            }
            if (!isChanged) {
                break;
            }
        }
    }

    public static void printArray(int input[]) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}

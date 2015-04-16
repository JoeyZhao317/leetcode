package com.learning;

public class MaxSumofArray {

    static int maxSum(int[] list) {
        int sum = list[0];
        int temp = 0;
        int start = 0;
        int end = 0;
        int startPosition[] = new int[list.length];
        int k = 1;
        startPosition[0] = 0;
        for (int i = 0; i < list.length; i++) {
            if (temp < 0) {
                // if the sum is negative, reset the position.
                temp = list[i];
                start = i;
                startPosition[k++] = start;
                // record all start positions
                // when reset the position, it maybe the new start of sub-array
            } else {
                temp = list[i] + temp;
            }

            if (temp > sum) {
                sum = temp;
                end = i;
                // record the end position
                // if we have the new sum, we should get the new end position of
                // array.
            }
        }
        // There is a little problem about the start position
        // We should choose the nearest start position to end position

        for (int t = k - 1; k >= 0; t--) {
            if (startPosition[t] <= end) {
                start = startPosition[t];
                break;
            }
        }

        System.out.print("The max sum array is [");
        for (int j = start; j <= end; j++)
            System.out.print(" " + list[j]);
        System.out.println(" ] and the max sum is: " + sum);

        return sum;
    }

    static public double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }

    public static void main(String[] args) {
        int[] test1 = { 1, -2, 3, -8, 9 };
        int[] test2 = { 3, -5, 9, 1, 2, -10 };
        int[] test3 = { -3, -1, -2 };
        int[] test4 = { -2, 3, 1, -5, 7, 9, -11, 34 };
        int[] test5 = { 8, 9, -20, 1 };
        int[] test6 = { -7, -6, 4, 8, -7, 6, -5, 4, -3, 2, -1 };
        maxSum(test1);
        maxSum(test2);
        maxSum(test3);
        maxSum(test4);
        maxSum(test5);
        maxSum(test6);
        System.out.println("Sqrt(3600)=" + log(3600, 2));
        System.out.println("Sqrt(60)=" + log(60, 2));
    }
}

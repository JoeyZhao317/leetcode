package com.buptcoder.leetcode;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || B == null || m * n == 0) {
            return;
        }
        int p = m - 1;
        int q = n - 1;
        int index = p + q - 1;
        for (int i = index; i >= 0; i--) {
            int tmpA, tmpB;
            if (p >= 0) {
                tmpA = A[p];
            } else {
                tmpA = Integer.MIN_VALUE;
            }

            if (q >= 0) {
                tmpB = B[q];
            } else {
                tmpB = Integer.MIN_VALUE;
            }
            if (tmpA > tmpB) {
                A[index--] = A[p--];
            } else {
                A[index--] = B[q--];
            }
        }
    }
    public static void main(String[] args) {
        MergeSortedArray o = new MergeSortedArray();
        int[] A = new int[7];
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;
        A[3] = 5;
        A[4] = 6;
        int[] B = new int[1];
        B[0] = 3;
        o.merge(A, 5, B, 1);
        System.out.print(A.toString());
    }
}

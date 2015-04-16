package com.buptcoder.acm;

//O(n) = lg(m+n)
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return 0;
    }

    private double getMedian(int A[]) {
        int length = A.length;
        if (length % 2 == 0) {
            return (A[length / 2 - 1] + A[length]) * 0.5;
        } else {
            return A[length / 2];
        }
    }

//    private double medianSearch(int[] A, int[] B, int left, int right) {
//        if (left > right) {
//            int tmp = (left + right) / 2;
//            return medianSearch(B, A, max(1, tmp - A.length),
//                    min(B.length, tmp));
//        }
//        int i = (left + right) / 2;
//        int j = (A.length + B.length) / 2 - i;
////        if( j = 0)
//    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int min(int a, int b) {
        return a > b ? b : a;
    }
}

package com.buptcoder.acm;

public class Equalrium {
    public int solution(int[] A) {
        // write your code here...
        if (A == null || A.length <= 0) {
            return -1;
        }
        int result = -1;
        int length = A.length;
        long totalSum = 0;
        for (int i = 0; i < length; i++) {
            totalSum += (long) A[i];
        }
        long lowerSum = 0;
        if (totalSum == 0) {
            if (A[0] == 0) {
                return 0;
            } else if (A[length - 1] == 0) {
                result = length - 1;
            }
        }
        for (int i = 0; i < length - 1; i++) {
            lowerSum += (long) A[i];
            long higherSum = (long) totalSum - lowerSum - A[i + 1];
            if (higherSum == lowerSum) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String [] args) {
        int[] testa = {2147483647, 2147483647,0,1,2147483647, 2147483646};
        Equalrium o = new Equalrium();
        System.out.println(o.solution(testa));
    }
}

package com.buptcoder.acm;

public class RemoveDuplicate {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = A.length;
        if(length == 0 || length == 1) {
            return length;
        }
        int front = 1, back = 1;
        int value = A[0];
        while(front < length) {
            if(A[front] == value) {
                front++;
            } else {
                value = A[front];
                A[back++] = A[front++];
            }
        }
        return back;
    }
}

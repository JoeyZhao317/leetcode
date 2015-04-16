package com.buptcoder.acm;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        int index = length - 1;
        int newLength = length;
        for (int i = length - 1; i >= 0; i--) {
            if (A[i] == elem) {
                newLength--;
                if (newLength == 0) {
                    break;
                }
                A[i] = A[index--];
            }
        }
        return newLength;
    }

    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (haystack == null) {
            return null;
        }
        if (needle == null) {
            return haystack;
        }
        int start = haystack.indexOf(needle);
        if (start != -1) {
            return haystack.substring(start);
        } else {
            return null;
        }
    }
}

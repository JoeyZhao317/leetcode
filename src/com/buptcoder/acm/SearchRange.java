package com.buptcoder.acm;

public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (A == null || A.length == 0) {
            return result;
        }

        int length = A.length;
        int start = 0;
        int end = length - 1;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int tmp = A[mid];
            if (tmp > target) {
                end = mid - 1;
            } else if (tmp < target) {
                start = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        if (index == -1) {
            return result;
        }

        start = index;
        end = index;
        for (int i = index; i >= 0; i--) {
            if (A[i] == target) {
                start = i;
            }
        }
        for (int j = index; j < length; j++) {
            if (A[j] == target) {
                end = j;
            }
        }
        result[0] = start;
        result[1] = end;
        return result;
    }
}

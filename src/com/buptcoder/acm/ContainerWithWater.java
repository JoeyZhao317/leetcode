package com.buptcoder.acm;

public class ContainerWithWater {
    public static int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = height.length;
        int max = 0, max_tmp = 0;
        for (int i = 0; i < count; i++) {
            int tmp = count - 1;
            max_tmp = (count - 1 - i) * min(height[i], height[tmp]);
            for (int j = count - 1; j > i; j--) {
                if (height[j] < height[tmp]) {
                    continue;
                } else {
                    int p = (j - i) * min(height[i], height[j]);
                    if (p > max_tmp) {
                        max_tmp = p;
                        tmp = j;
                    }
                }
            }
            if (max < max_tmp) {
                max = max_tmp;
            }
            max_tmp = 0;
        }
        return max;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String args[]) {
     
//        System.out.println(maxArea(test));
    }
}

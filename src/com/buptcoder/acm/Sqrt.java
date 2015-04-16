package com.buptcoder.acm;

public class Sqrt {
    public static int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x <= 0) {
            return 0;
        }
        for (Long i = 0L; i < x / 2; i++) {
            if (i * i >= x) {
                return i.intValue();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(9));
        System.out.println(sqrt(2147483647));
        long seconds = 34 << 12 + 30 << 5;
        System.out.println(seconds);
        long packegeId = (seconds << 10) + 111;
        System.out.println(packegeId);
    }
}

class Solution {
    public int sqrt(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        assert (x >= 0);
        if (x == 0)
            return 0;
        double val = x;
        double last;
        do {
            last = val;
            val = (val + x / val) / 2.0;
        } while (Math.abs(val - last) > 0.000001);
        return (int) val;
    }
};

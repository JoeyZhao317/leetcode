package com.buptcoder.acm;

public class PalindromeNumber {
    //Time Limit Exceeded in Java ! but c++ accepted
    //Time: Program Runtime: 340 milli secs in C++ (11499 testcases)
    public static boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int max_int = 1000000000;
        int size = 0;
        for (int i = 0; i < 10; i++) {
            if (x / max_int == 0) {
                max_int = max_int / 10;
            } else {
                size = 10 - i;
                break;
            }
        }

        for (int j = 0; j < size / 2; j++) {
            if (x / max_int == x % 10) {
                x = x % max_int;
                x = x / 10;
                max_int = max_int / 100;
            } else {
                return false;
            }
        }
        return true;
    }

    //Time Limit Exceeded in Java but accepted in C++
    // Program Runtime: 284 millisecs in C++ (11499 testcases)
    public static boolean isPalindNumber(int input) {
        int origin = input;
        int reverse = 0;
        while (input > 0) {
            int remain = input%10;
            input = input/10;
            reverse = reverse*10+remain;
        }
        return reverse == origin;
    }

    
    public static void main(String args[]) {
        System.out.println(isPalindrome(112011211));
        System.out.println(isPalindNumber(112011211));
    }
}

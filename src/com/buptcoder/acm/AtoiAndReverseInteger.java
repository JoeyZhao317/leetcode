package com.buptcoder.acm;

public class AtoiAndReverseInteger {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Long result = 0l;
        boolean isNegative = false;
        boolean startWithNumber = false;
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp >= '0' && tmp <= '9') {
                result = result * 10 + (tmp - '0');
                startWithNumber = true;
            } else if (tmp == '-' || tmp == '+') {
                if (!startWithNumber) {
                    startWithNumber = true;
                    if (tmp == '-') {
                        isNegative = true;
                    }
                } else {
                    break;
                }

            } else {
                break;
            }
        }
        if (isNegative) {
            result = 0 - result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return Integer.valueOf(Integer.valueOf(result.intValue()));
    }

    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean isNegative = x < 0 ? true : false;
        String s = String.valueOf(Math.abs(x));
        StringBuilder builder = new StringBuilder();
        if (isNegative) {
            builder.append("-");
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return Integer.valueOf(builder.toString());
    }
}

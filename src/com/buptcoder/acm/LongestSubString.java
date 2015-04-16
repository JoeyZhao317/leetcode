package com.buptcoder.acm;

public class LongestSubString {
    private static boolean[] existChar = new boolean[256];

    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        if (isValidString(s)) {
            result = findLongestSubString(s);
        }
        return result;
    }

    private boolean isValidString(String s) {
        boolean isValidString = true;
        if (s == null || s.length() == 0) {
            isValidString = false;
        }
        return isValidString;
    }

    private int findLongestSubString(String s) {
        int length = s.length();
        int longest = 0;
        int subLengthTmp = 0;
        int lastRepeatIndex = 0;
        resetExistArray();
        for (int i = 0; i < length; i++) {
            char tmp = s.charAt(i);
            if (existChar[tmp]) {
                subLengthTmp++;
                existChar[tmp] = true;
            } else {
                int tempExchange = lastRepeatIndex + 1;
                lastRepeatIndex = i;
                i = tempExchange;
                resetExistArray();
                if (subLengthTmp > longest) {
                    longest = subLengthTmp;
                }
            }
        }
        return longest;
    }

    private void resetExistArray() {
        for (int i = 0; i < 256; i++) {
            existChar[i] = false;
        }
    }

   public static void main(String [] args) {
       String testString1 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
       LongestSubString test = new LongestSubString();
       System.out.println(test.lengthOfLongestSubstring(testString1));
   }
}
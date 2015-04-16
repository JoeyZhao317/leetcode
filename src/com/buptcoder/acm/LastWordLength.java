package com.buptcoder.acm;

public class LastWordLength {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int lastWordIndex = -1;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != ' ') {
                lastWordIndex = i;
            }
        }

        if (lastWordIndex == -1) {
            return 0;
        }
        int lastSpaceIndex = -1;
        for (int i = 0; i < lastWordIndex; i++) {
            if (s.charAt(i) == ' ') {
                lastSpaceIndex = i;
            }
        }
        return lastWordIndex - lastSpaceIndex;
    }
}

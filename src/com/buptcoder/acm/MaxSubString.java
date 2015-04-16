package com.buptcoder.acm;

public class MaxSubString {
    private int[] map = new int[26];
    //Try to find more efficient method.
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // abcbbdcd dyamic programming
        // abc
        int max = 0;
        int max_tmp = 0;
        int start = 0;
        int end = 0;
        int start_tmp = 0;
        int end_tmp = 0;
        resetMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c - 'a'] > 0) {
                end_tmp = i;
                if (max < max_tmp) {
                    max = max_tmp;
                    end = end_tmp;
                    start = start_tmp;
                }
                i = map[c - 'a'] - 1;
                max_tmp = 0;
                start_tmp = i;// ???
                resetMap();
            } else {
                max_tmp++;
                map[c - 'a'] = i + 1;
            }
        }
        if (max < max_tmp) {
            max = max_tmp;
            start = start_tmp;
            end = s.length();
        }
        System.out.println(s.substring(start,end));
        return max;
    }

    private void resetMap() {
        for (int i = 0; i < map.length; i++) {
            map[i] = 0;
        }
    }
    
    public static void main(String args[]) {
        MaxSubString instance = new MaxSubString();

        String test = "inprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparating";
        System.out.println(instance.lengthOfLongestSubstring("bbbb"));
        System.out.println(instance.lengthOfLongestSubstring("abcdcefcg"));
        System.out.println(instance.lengthOfLongestSubstring("abcddcbae"));
        System.out.println(instance.lengthOfLongestSubstring(test));
        
    }
}
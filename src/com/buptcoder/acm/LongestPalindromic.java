package com.buptcoder.acm;

public class LongestPalindromic {

    public static void main(String args[]) {
        String test1 = "cc";
        String test2 = "11";
        System.out.println(longestPalindrome(test1));
        System.out.println(longestPalindrome(test2));
    }

    public static String longestPalindrome(String s) {
        int count = s.length();
        int longest = 0, longest_tmp = 0;
        int mid = 0;
        StringBuilder builder = new StringBuilder();
        builder.append('&');
        for(int i = 0; i < count; i++) {
            builder.append(s.charAt(i));
            builder.append('&');
        }
        String nospcialString = builder.toString();
        int length = nospcialString.length();
        for (int i = 0; i < length - 1; i++) {
            int tmp = length - i - 1;
            if(longest > tmp) {
                break;
            }
            int k = tmp >  i ?  i : tmp;
            for (int j = 1; j <= k; j++) {
                if (nospcialString.charAt(i + j) == nospcialString.charAt(i - j)) {
                    longest_tmp++;
                    if (j == k) {
                        if (longest < longest_tmp) {
                            longest = longest_tmp;
                            mid = i;
                        }
                        longest_tmp = 0;
                    }
                } else {
                    if (longest < longest_tmp) {
                        longest = longest_tmp;
                        mid = i;
                    }
                    longest_tmp = 0;
                    break;
                }
            }
        }
        System.out.println("mid=" + mid + ",longest=" + longest);
        String origial = nospcialString.substring(mid - longest, mid + longest + 1);
        return origial.replace("&", "");
    }
}

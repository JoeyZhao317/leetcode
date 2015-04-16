package com.buptcoder.acm;

/*
 *  nRows = 4
 0     6     12 ...
 1   5 7   11
 2 4   8 10  
 3     9
 */

/*
 *  nRows = 5
 0     8      16 ...
 1   7 9     15
 2  6  10   14  
 3 5   11 13
 4     12
 */

public class ZipzagString {
    public static String convert1(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int length = s.length();
        if (length == 0 || nRows == 1) {
            return s;
        }
        StringBuilder[] builders = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) {
            builders[i] = new StringBuilder();
        }
        int interval = 2 * nRows - 2;
        builders[0].append(s.charAt(0));
        for (int i = 1; i < length; i++) {
            char tmp = s.charAt(i);
            int index = i % interval;
            if (index < nRows) {
                builders[index].append(tmp);
            } else {
                int index2 = interval - i % interval;
                builders[index2].append(tmp);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < nRows; j++) {
            result.append(builders[j].toString());
        }
        return result.toString();
    }

    //faster!
    public static String convert2(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function

        int length = s.length();
        if (length == 0 || nRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int interval = 2 * nRows - 2;
        for (int j = 0; j < nRows; j++) {
            for (int i = j;; i+=interval) {
                if(i >= length) {
                    break;
                }
                result.append(s.charAt(i));
                if( j > 0 && j < nRows-1) {
                    int ti = i + interval - 2 * j;
                    if(ti < length){
                        result.append(s.charAt(ti));
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String args[]) {
        String test = "11";
        System.out.println(convert1(test, 3));
        System.out.println(convert2(test, 3));
    }
}

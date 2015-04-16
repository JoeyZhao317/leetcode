package com.buptcoder.acm;

public class StringMultiple {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Long number1 = Long.valueOf(num1);
        Long number2 = Long.valueOf(num2);
        return String.valueOf(number1 * number2);
    }
    public static void main(String[] args) {
        StringMultiple o = new StringMultiple();
        o.multiply("401716832807512840963", "167141802233061013023557397451289113296441069");
    }
}

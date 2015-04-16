package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interview {
    private int test = 5;
    enum NUMBER {
        ONE, TWO;
        public void print() {
            switch (this) {
                case ONE:
                    System.out.print(this.toString());
                    break;
                case TWO:
                    break;
            }
        }
    }

    NUMBER a = NUMBER.valueOf("ONE");

    public static void main(String[] args) {
        int a = 5;
        // System.out.print("the value is" + ((a<5) ? 10.9:9));
        
        System.out.println("请输入一个整数");
        a = InputData.getInt();
        System.out.println("a的平方是:" + a * a);
        System.out.println("a的立方是:" + a * a * a);
        if ((a & (a - 1)) == 0) {
            System.out.println(a + " 是2的阶次");
        } else {
            System.out.println(a + " 不是2的阶次");
        }
        InputData.getMaxOne();
        Interview view = new Interview();
        System.out.println(view.test);
    }

    public static void testFun() {

    }
}
//
class InputData {

    static private String s = "";

    static public void input() {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = bu.readLine();
        } catch (IOException e) {
        }
    }

    static public int getInt() {
        input();
        try {
            int in = Integer.parseInt(s);
            return in;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    static int getOne(int n) {
        String num = n + "";
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char tmp = num.charAt(i);
            if (tmp == '1') {
                count++;
            }
        }
        return count;
    }

    static void getMaxOne() {
        int allCount = 1;
        int n = 2;
        while ((getOne(n) + allCount) != n) {
            allCount += getOne(n);
            n++;
        }
        System.out.println("The largest of n is : " + n);
       
    }
}

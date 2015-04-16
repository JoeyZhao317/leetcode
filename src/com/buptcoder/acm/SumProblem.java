package com.buptcoder.acm;

import java.util.Scanner;

/*
 *
 ACM 1000
 http://poj.org/problem?id=1000
 Description

 Calculate a+b
 Input

 Two integer a,b (0<=a,b<=10)
 Output

 Output a+b
 Sample Input

 1 2
 Sample Output

 3
 */
public class SumProblem {
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt(), b = cin.nextInt();
        System.out.println(a + b);
    }
}

package com.buptcoder.acm;

import java.util.ArrayList;

public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        char[] tmp = new char[2 * n];
        generate(n, n, result, tmp, 0);
        return result;
    }

    private void generate(int left, int right, ArrayList<String> result,
            char[] tmp, int index) {
        System.out.println("left = " + left + ", right = " + right);
        if (left == 0 && right == 0) {
            System.out.println("tmp = " + String.valueOf(tmp));
            result.add(String.valueOf(tmp));
            return;
        }
        if (left > 0) {
            tmp[index] = '(';
            generate(left - 1, right, result, tmp, index + 1);
        }

        if (left < right) {
            tmp[index] = ')';
            generate(left, right - 1, result, tmp, index + 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses o = new GenerateParentheses();
        o.generateParenthesis(3);
    }
}

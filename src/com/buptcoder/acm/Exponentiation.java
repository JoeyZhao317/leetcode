/*
 * Description

Problems involving the computation of exact values of 
very large magnitude and precision are common. 
For example, the computation of the national debt 
is a taxing experience for many computer systems. 

This problem requires that you write a program 
to compute the exact value of Rn where R is a 
real number ( 0.0 < R < 99.999 ) and n is an 
integer such that 0 < n <= 25.

Input

The input will consist of a set of pairs of 
values for R and n. The R value will occupy 
columns 1 through 6, and the n value will be in columns 8 and 9.
Output

The output will consist of one line for
 each line of input giving the exact 
 value of R^n. Leading zeros should 
 be suppressed in the output. 
 Insignificant trailing zeros must not be printed.
Don't print the decimal point if the result is an integer.
Sample Input

95.123 12
0.4321 20
5.1234 15
6.7592  9
98.999 10
1.0100 12
Sample Output

548815620517731830194541.899025343415715973535967221869852721
.00000005148554641076956121994511276767154838481760200726351203835429763013462401
43992025569.928573701266488041146654993318703707511666295476720493953024
29448126.764121021618164430206909037173276672
90429072743629540498.107596019456651774561044010001
1.126825030131969720661201
Hint

If you don't know how to determine whether encounted the end of input: 
s is a string and n is an integer 
 */
package com.buptcoder.acm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Exponentiation {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            BigDecimal R = in.nextBigDecimal();
            int n = in.nextInt();
            R = R.pow(n);
            String str = R.stripTrailingZeros().toPlainString();
            if (str.startsWith("0.")) {
                str = str.substring(1);
            }
            get(1);
            System.out.println(str);
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * 
     * <p>
     * This method is <i>not</i> guaranteed to run in constants time. In some
     * implements it may run in time proportional to the element position.
     * 
     * @param index
     *            index of element to return; must be non-negative and less than
     *            the size of this list
     * @return the element at the specified position in this list
     * @throws IndexOutofBoundsException
     *             if the index is out of range (
     *             {@code index<0 || index >= this.size()})
     */
    private static <E> E get(int index) {
        return null;
    }

    enum Suit {
        CLUB, DIAMOND, HEART, SPADE
    };

    enum Rank {
        ACE, DEUCE, THERE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    };

    private void test() {
        Collection<Suit> suits = Arrays.asList(Suit.values());
        Collection<Rank> ranks = Arrays.asList(Rank.values());
        List<Card> deck = new ArrayList<Card>();
        for (Iterator<Suit> i = suits.iterator(); i.hasNext();) {
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext();) {
                //bug!
                deck.add(new Card(i.next(), j.next()));
            }
        }
        for(Suit suit:suits) {
            for(Rank rank:ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }
 
    class Card {
        Card(Suit suite, Rank rank) {
        }
    }
}

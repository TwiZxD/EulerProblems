package com.company;

import java.math.BigInteger;

/**
 The Fibonacci sequence is defined by the recurrence relation:

 Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 Hence the first 12 terms will be:

 F1 = 1
 F2 = 1
 F3 = 2
 F4 = 3
 F5 = 5
 F6 = 8
 F7 = 13
 F8 = 21
 F9 = 34
 F10 = 55
 F11 = 89
 F12 = 144
 The 12th term, F12, is the first term to contain three digits.

 What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem25 {

    public Problem25() {
        int index = 3;

        BigInteger fib1;
        BigInteger fib2 = new BigInteger("1");
        BigInteger fib3 = new BigInteger("2");

        while(true) {
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1.add(fib2);
            index++;
            if(index%10000 == 0) {
                System.out.println("F" + index + " = " + fib3.toString().length());
            }
            if(fib3.toString().length() >= 1000) {
                System.out.println("Fib " + index + " = " + fib3.toString().length() + " in length");
                break;
            }
        }

    }
}

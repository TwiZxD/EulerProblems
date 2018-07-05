package com.company;

import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */

public class Problem16 {
    public Problem16 () {
        solveProblem();
    }

    private void solveProblem() {
        BigInteger sumOfPow = new BigInteger("2").pow(1000);
        String sumPowToString = sumOfPow.toString();
        System.out.println("Total String: " + sumPowToString);
        int sumOfDigits = 0;
        for(int i = 0; i < sumPowToString.length();  i++) {
            sumOfDigits = sumOfDigits + (sumPowToString.charAt(i) - '0');
        }
        System.out.println("Sum of all Digits: " + sumOfDigits);
    }

}

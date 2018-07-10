package com.company;

import java.math.BigInteger;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

public class Problem20 {

    Problem20() {
        BigInteger factorialSum = new BigInteger("1");
        BigInteger temp;

        for(int i = 1; i <= 100; i++) {
            temp = new BigInteger(Integer.toString(i));
            factorialSum = factorialSum.multiply(temp);
        }

        String s = factorialSum.toString();
        int sumOfDigits = 0;
        for(int i = 0; i < s.length(); i++) {
            sumOfDigits = sumOfDigits + s.charAt(i) - '0';
        }

        System.out.println("Sum = " + sumOfDigits);

    }

}

package com.company;

/**
 *
 Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

 For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

 Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21 {

    public Problem21() {
        int sum = 0;
        for (int i = 2; i <= 10000; i++) {
            sum = sum + checkIfAmicable(i);
        }
        System.out.println("Total sum = " + sum);
    }

    private int checkIfAmicable(int number) {
        //A = Number

        //d(A) = dASum
        int dAsum = 0;
        for(int i = 1; i < number; i++) {
            if(number % i == 0) {
                dAsum = dAsum + i;
            }
        }

        //d(B) = dBSum
        int dBsum = 0;
        for(int i = 1; i< dAsum; i++) {
            if(dAsum % i == 0) {
                dBsum = dBsum + i;
            }
        }

        if (number == dBsum && number != dAsum) { /* d(a) == d(b)  and  a != b */
            System.out.println("A = " + number + " B = " + dAsum + " BSum = " + dBsum);
            return dAsum;
        }

        return 0; //Return 0 if Number is not an Amicable number.
    }

}

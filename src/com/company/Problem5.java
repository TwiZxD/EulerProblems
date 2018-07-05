package com.company;

/**
 * Problem5
 * Smallest multiple
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */


public class Problem5 {
    public Problem5() {
        solveProblem();
    }


    /**
     * Brute Force
     */
    private void solveProblem() {
        long number = 20;
        boolean solved = false;

        while(!solved) {
            number++;
            solved = true;
            for(int i = 2; i<=20;i++) {
                if(number % i != 0) {
                    solved = false;
                    break;
                }
            }

        }
        System.out.println("Answer: " + number);
    }
}

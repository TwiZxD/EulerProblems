package com.company.projectEuler;

/**
 * Problem 7
 * 10001st prime
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */

/*
 * Solution
 * Find 10000 primes and print the next one.
 */
public class Problem7 {
    //ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

    public Problem7() {
        int sizeOfNumbers = 100000;

        //If we haven't found the prime we want, do it again with a larger array.
        while(!solveProblem(sizeOfNumbers)) {
            System.out.println("Done");
            sizeOfNumbers = sizeOfNumbers*2;
        }
    }

    /**
     * Find all prime numbers up to a given number.
     * @param maximumAmountOfNumbersToBeChecked Prime numbers to be found up to this number.
     * @return returns true if a specific condition is meet. The condition is hard coded for this specific problem.
     */
    private boolean solveProblem(int maximumAmountOfNumbersToBeChecked) {
        int amountOfPrimes = 0;
        boolean numbers[] = new boolean[maximumAmountOfNumbersToBeChecked]; //After going threw the list, False means the numbers are primes.

        for(int i = 2; i < maximumAmountOfNumbersToBeChecked; i++) {

            if(!numbers[i]) {
                //Found a Prime Number
                amountOfPrimes++;

                //primeNumbers.add(i); //If we need to list all prime numbers.

                if(amountOfPrimes == 10001) {
                    System.out.println("10001 prime is: " + i);
                    return true;
                }
                //Remove further numbers that can be divided with current prime number.
                int j = i + i;
                while(j < maximumAmountOfNumbersToBeChecked) {
                    numbers[j] = true;
                    j = j + i;
                }
            }
        }

        System.out.println("amount of Primes found:" + amountOfPrimes);
        return false;
    }



}

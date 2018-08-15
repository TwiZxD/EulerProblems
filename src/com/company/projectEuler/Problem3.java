package com.company.projectEuler;

import java.util.ArrayList;

/**
 The prime factors of 13195 are 5, 7, 13 and 29.

 What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {
    public Problem3() {
        long problemNumber = 600851475143L;
        //   int problemNumber = 13195;
        ArrayList<Integer> primeNumbersUpTo10000 = new ArrayList<Integer>();
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();

        for(int i = 2; i < 10000; i++) {
            if(isPrime(i)) {
                primeNumbersUpTo10000.add(i);
            }
        }

        long breakTest;
        while(problemNumber != 1){
            breakTest = problemNumber;

            for (int i = 0; i < primeNumbersUpTo10000.size(); i++) {
                if((problemNumber%primeNumbersUpTo10000.get(i)) == 0) {
                    primeFactors.add(primeNumbersUpTo10000.get(i));
                    int test = primeNumbersUpTo10000.get(i);
                    problemNumber = problemNumber/test;
                    break;
                }
            }
            if(breakTest == problemNumber) {
                System.out.println("Error at number: " + breakTest);
                break;
            }
        }

        for (Integer factors : primeFactors) {
            System.out.print(factors + ", ");
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++ ){
            if((number%i == 0)) {
                return false;
            }
        }
        return true;
    }

}

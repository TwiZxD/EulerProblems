package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

/*
My programming solutions for the problems from project euler!
https://projecteuler.net/archives

*/
public class Main {
    public static void main(String[] args) {
	//    Problem_4();
	    Problem10 problem = new Problem10();
    }

    /*
    Problem 1
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.
     */
    private static void Problem_1() {
        int sum = 0;
        for(int i = 1; i < 1000; i ++) {
           if((i % 3) == 0 || (i % 5) == 0) {
                sum = sum + i;
           }
        }
        System.out.println(Integer.toString(sum));
    }

    /*
    Problem 2
    Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
     */
    private static void Problem_2() {
        int currentFibNumber = 1;
        int previousFib = 1;
        int tempFib;
        int sum = 0;

        while (currentFibNumber < 4000000) {
            tempFib = currentFibNumber;
            currentFibNumber = currentFibNumber + previousFib;
            previousFib = tempFib;
            if((currentFibNumber % 2) == 0) {
                sum = sum + currentFibNumber;
            }
        }
        System.out.println( Integer.toString(sum));
    }
/*
    Problem 3
    The prime factors of 13195 are 5, 7, 13 and 29.

    What is the largest prime factor of the number 600851475143 ?
*/
    private static void Problem_3 () {
        long problemNumber = 600851475143L;
     //   int problemNumber = 13195;
        ArrayList<Integer> primeNumbersUpTo10000 = new ArrayList<Integer>();
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();

        for(int i = 2; i < 10000; i++) {
            if(isPrime(i)) {
                primeNumbersUpTo10000.add(i);
            }
        }

        long breakTest = 0;
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

        //Print
        for(int i = 0; i < primeFactors.size();i++) {
            System.out.print(primeFactors.get(i) + ", ");
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

    private static void Problem_4() {
        System.out.println("Problem 4");
    }
    private static void Problem_X() {
        System.out.println("Mall");
    }

}





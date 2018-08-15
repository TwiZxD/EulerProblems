package com.company.projectEuler;

/**
 * Sum square difference
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Problem6 {
    public Problem6() {
        System.out.println("Answer: " + solveProblem());
    }

    private int solveProblem() {
        int sumOfSquares = 0;
        int squareOfSum = 0;
        for(int i = 1; i <=100;i++) {
            //Sum of the squares
            sumOfSquares = sumOfSquares + (i*i);
            //square of the sum
            squareOfSum = squareOfSum + i;
        }
        squareOfSum = squareOfSum * squareOfSum;
        return squareOfSum - sumOfSquares;
    }
}

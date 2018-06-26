package com.company;

/**
 * Largest palindrome product
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Problem4 {
    public Problem4() {
        SolveProblem();
    }

    private void SolveProblem() {
        int numberToBeTested;
        int highestNumber = 0;
        for(int i = 0; i <= 999; i++) {
            for(int ii = 0; ii <= 999; ii++) {
                numberToBeTested = i * ii;
                try {
                    if(checkPalindrome(numberToBeTested)) {
                        if(highestNumber < numberToBeTested) {
                            highestNumber = numberToBeTested;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Answer: " + highestNumber);
    }

    private boolean checkPalindrome(int number) {
        if(number<10) {
            return false;
        }

        String s = Integer.toString(number);
        int startPointer = 0;
        int endPointer = s.length() - 1;

        int start, end;
        while(startPointer <= endPointer) {
            start = s.charAt(startPointer);
            end = s.charAt(endPointer);
            if(start != end) {
                return false;
            }
            startPointer++;
            endPointer--;
        }
        return true;
    }
}

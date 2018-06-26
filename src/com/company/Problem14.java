package com.company;

import java.util.ArrayList;

public class Problem14 {
    Problem14() {
        int longestSequence = 0;
        int HighestNumber = 0;
        int number;
        for(int i = 1000000; i > 5000; i--) {

          //  System.out.println("Number: " + i);
            number = testNumber(i);
            if(number > longestSequence) {
                longestSequence = number;
                HighestNumber = i;
            }
        }
        System.out.println("HighestNumber = " + HighestNumber);
    }

    private int testNumber(long n) {
        ArrayList<Long> numbers = new ArrayList<Long>();
        while(n!=1) {
      //      System.out.print(n + ", ");
            numbers.add(n);
            n = rule(n);
        }
        return numbers.size();

    }

    private long rule(long n) {
        if(n % 2 == 0) { //Check if even
            n = n/2;
        } else {
            n = 3*n + 1;
        }
        return n;
    }



}

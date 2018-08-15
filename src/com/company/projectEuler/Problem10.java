package com.company.projectEuler;

import java.util.ArrayList;

public class Problem10 {
    public Problem10() {
        ArrayList<Integer> prime = createPrime(2000000);
        printPrime(prime);
        sumOfPrime(prime);
    }
    private static void sumOfPrime(ArrayList<Integer> prime) {
        long sum = 0;
        for(int i = 0; i < prime.size();i++) {
            sum = sum + prime.get(i);
        }
        System.out.println("Sum of all primes = " + sum);
    }


    /*
    prime: array [1..n] of boolean = all true
    for p in 2..sqrt(n) loop
    if prime[p] then
        m = p*p
        while m <= n loop
            prime[m] = false
            m = m+p
        end loop
    end if
    end loop
*/
    //n is the number of the highest primenumber.
    public static ArrayList<Integer> createPrime(int n) {
        ArrayList<Boolean> primeNumbers = new ArrayList<Boolean>();
        ArrayList<Integer> prime = new ArrayList<Integer>();
        for(int i = 0; i<n; i++) {
            primeNumbers.add(true);


        }
        for(int p = 2; p < Math.sqrt(n); p++) {
            if(primeNumbers.get(p)) {
                int m = p*p;
                while(m < n) {
                    primeNumbers.set(m, false);
                    m = m+p;
                }
            }
        }
        for(int i = 2; i < n; i++) {
            if(primeNumbers.get(i) == true) {
                prime.add(i);
            }
        }

        return prime;

    }

    public static void printPrime(ArrayList<Integer> primeNumbers) {
        for(int i = 0; i < primeNumbers.size();i++) {
            System.out.print(primeNumbers.get(i) + ", ");
            System.out.println();
        }
    }

}

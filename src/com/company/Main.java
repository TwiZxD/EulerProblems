package com.company;

/**
My programming solutions for euler problems found at: https://projecteuler.net/
username: twizeuler
*/
public class Main {
    public static void main(String[] args) {
        long timerStart = System.currentTimeMillis();

	    new Problem22();
        //new Problem22(); //TODO
	    System.err.println("Found in: " + (System.currentTimeMillis() - timerStart) + " ms");
    }
}





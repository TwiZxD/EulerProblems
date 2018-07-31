package com.company;

import com.company.algorithms.testDijkstra;

/**
My programming solutions for euler problems found at: https://projecteuler.net/
username: twizeuler
*/
public class Main {
    public static void main(String[] args) {
        long timerStart = System.currentTimeMillis();
        //TODO Problem 22
        //TODO Problem 24
        //TODO Problem 45
	    //new Problem22();
        new testDijkstra();
	    System.err.println("Found in: " + (System.currentTimeMillis() - timerStart) + " ms");
    }
}





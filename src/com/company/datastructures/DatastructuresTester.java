package com.company.datastructures;

/**
 * Algoritms for sorting basic int arrays
 */

public class DatastructuresTester {

    public void run() {
        /** Algorithms*/
        InsertionSort is = new InsertionSort();
        SelectionSort ss = new SelectionSort();
        QuickSort qs = new QuickSort();
        BubbleSort bs = new BubbleSort();

        /** Choose algorithm to test*/
        testArray(bs);

    }

    private static void testArray(IAlgorithm algo){
        int[] oneToTwo = {1,2};
        int[] twoToOne = {2,1};
        int[] shortArrat = {10,8,12};
        int[] randomArray = {10,2,8,5,3,6,2,3,5,8,9,13,20};
        int[] TenToOne = {10,9,8,7,6,5,4,3,2,1};
        int[] oneToTen = {1,2,3,4,5,6,7,8,9,10};
        int[] nullArray = null;
        int[] emptyArray = {};
        int[] oneElementArray = {1337};

        System.out.println("Testing: " + algo.nameOfAlgorithm());

        System.out.println("Starting Array:");
        printArray(oneToTwo);
        algo.sort(oneToTwo);
        printArray(oneToTwo);
        System.out.println();

        System.out.println("Starting Array:");
        printArray(twoToOne);
        algo.sort(twoToOne);
        printArray(twoToOne);
        System.out.println();

        System.out.println("Starting Array:");
        printArray(shortArrat);
        algo.sort(shortArrat);
        printArray(shortArrat);
        System.out.println();

        System.out.println("Starting Array:");
        printArray(randomArray);
        algo.sort(randomArray);
        printArray(randomArray);
        System.out.println();

        System.out.println("Starting Array:");
        printArray(TenToOne);
        algo.sort(TenToOne);
        printArray(TenToOne);
        System.out.println();

        System.out.println("Starting Array:");
        printArray(oneToTen);
        algo.sort(oneToTen);
        printArray(oneToTen);
        System.out.println();

        System.out.println("Test with null array");
        System.out.print("Responce: ");
        algo.sort(nullArray); System.out.println();

        System.out.println("Test with empty {} array");
        System.out.print("Responce: ");
        algo.sort(emptyArray); System.out.println();

        System.out.println("Test with one element array ");
        System.out.print("Responce: ");
        algo.sort(oneElementArray);
        System.out.print("We are "); printArray(oneElementArray);

    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}

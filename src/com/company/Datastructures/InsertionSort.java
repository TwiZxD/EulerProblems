package com.company.Datastructures;

/**
 * Complexity: O(n^2) using comparisons & swaps
 * How it works: https://www.youtube.com/watch?v=JU767SDMDvA&index=11&list=UUzDJwLWoYCUQowF_nG3m5OQ
 */

public class InsertionSort extends AbstractAlgorithm {

    public void sort(int[] array) {
        /**Wrapper*/
        if(array != null && array.length > 1) {
            insertionSort(array);
        } else {
            System.out.println("Array is null or too short");
        }
    }

    private void insertionSort(int[] list) {
        if(list == null){
            System.out.println("Array can't be null");
            return;
        }
        if(list.length < 2){
            System.out.println("InsertionSort won't run because array smaller than 2");
            return;
        }

        for(int i = 0; i < list.length; i++ ){
            int j = i;
            while(j > 0 ) {
                if(list[j] < list[j-1]) {
                    swap(list,j,j-1);
                }
                j--;
            }
        }
    }

    public String nameOfAlgorithm() {
        return "Insertion Sort";
    }

}

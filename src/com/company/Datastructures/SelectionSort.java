package com.company.Datastructures;

/**
 * Complexity: O(n^2)
 * How it works: https://www.youtube.com/watch?v=g-PGLbMth_g&index=10&list=UUzDJwLWoYCUQowF_nG3m5OQ
 */
public class SelectionSort extends AbstractAlgorithm {

    public void sort(int[] array) {
        /**Wrapper*/
        if(array != null && array.length > 1){
            ss(array);
        } else {
            System.out.println("Null or length not larger than 1");
            return;
        }
    }

    public void ss(int[] array) {
        for(int j = 0; j < array.length -1; j++) {
            int iMin = j;

            for(int i = j + 1; i < array.length; i++) {
                if(array[i] <  array[iMin]){
                    iMin = i;
                }
            }

            if(iMin != j) {
                swap(array,j, iMin);
            }
        }
    }

    public String nameOfAlgorithm() {
        return "Selection Sort";
    }
}

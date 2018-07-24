package com.company.Datastructures;
/**
 * Complexity: O(n^2)
 */
public class BubbleSort extends AbstractAlgorithm {

    public void sort(int[] array) {
        if(array != null && array.length > 1) {
            bubbleSort(array);
        } else {
            System.out.println("Array is null or too short");
        }
    }

    private void bubbleSort(int[] array) {
        for(int i = 0;  i < array.length - 1; i++ ) {
            for(int j = 1; j < array.length - i; j++) {
                if(array[j] < array[j - 1]) {
                    swap(array, j, j - 1) ;
                }
            }
        }
    }

    public String nameOfAlgorithm() {
        return "Bubble Sort";
    }
}

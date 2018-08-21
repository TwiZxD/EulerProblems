package com.company.datastructures;

public class MergeSort implements IAlgorithm {

    public void sort(int[] array) {
        if(array == null) {
            System.out.println("Array can't be null");
            return;
        }

        if(array.length > 1) {
            int halfSize = array.length /2;
            int[] leftArray = new int[halfSize];
            int[] rightArray = new int[array.length - halfSize];
            System.arraycopy(array, 0,leftArray, 0,halfSize);
            System.arraycopy(array, halfSize,rightArray, 0,array.length - halfSize);
            sort(leftArray);
            sort(rightArray);

            merge(array, leftArray, rightArray);
        }
    }

    private void merge (int[] outputSequence, int[] leftSequence, int[] rightSequence) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < leftSequence.length && j < rightSequence.length) {
            if(leftSequence[i] < rightSequence[j]) {
                outputSequence[k++] = leftSequence[i++];
            } else {
                outputSequence[k++] = rightSequence[j++];
            }

        }

        //If one of the sequence has more items to copy.
        while(i < leftSequence.length) {
            outputSequence[k++] = leftSequence[i++];
        }
        while(j < rightSequence.length) {
            outputSequence[k++] = rightSequence[j++];
        }
    }
    public String nameOfAlgorithm() {
        return "Merge Sort";
    }
}

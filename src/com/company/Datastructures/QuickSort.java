package com.company.Datastructures;

public  class QuickSort extends AbstractAlgorithm {

    public void sort(int[] f) {
        /**Wrapper**/
        if (f != null && f.length > 1) {
            qs(f, 0, f.length - 1);
        } else {
            System.out.println("Array is either null or too short");
        }
    }

    private void qs (int [] f, int low, int high) {
        int pivot, middle;
        pivot = findPivot(f, low, high);
        if (pivot != -1) {
            swap(f, pivot, high);
            pivot = high;
            middle = partition(f, low, high, pivot);
            swap(f, middle, pivot);
            qs(f, low, middle -1);
            qs(f, middle + 1, high);
        }
    }

    private int partition(int[] f, int low, int high, int pivot) {
        while (low < high ){
            while (low < high && f[low] < f[pivot] ) {
                low = low + 1;
            }

            while (low < high && f[high] >= f[pivot]) {
                high = high -1;
            }
            if (low < high ) {
                swap(f, low, high);
            }
        }
        return low;
    }


    private int findPivot(int[] f, int low, int high) {
        for(int i = low; i < high; i++) {
            if (f[i] != f[i + 1] ) {
              //  System.out.println("low+high/2" + (low + high) / 2);
                return (low + high) / 2;
            }
        }
        //System.out.println("Return -1 findPivot");
        return -1;
    }

    int fndpivot(int[] f, int low, int high) {
        if (low<high) {
            int[] ind = {low, ((low+high)/2), high};
            int[] tmp = {f[low], f[(low+high)/2], f[high]};
            for (int i=1; i<=2; i++) { // sort 3 numbers
                int j = i;
                while ( j>0 && tmp[j] < tmp[j-1] ) {
                    swap(tmp, j, j-1);
                    swap(ind, j, j-1);
                    j = j-1;
                }
            } // end for
            return ind[1];
        }
        return -1; // low>high
    } // end fndpivot

    public String nameOfAlgorithm() {
        return "Quicksort";
    }

}

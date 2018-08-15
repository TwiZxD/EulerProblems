package com.company.projectEuler;

/**
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed
 * numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 *
 *      012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

/* Solution: Create a tree and count leaves
          Root
     /     \       \
    0       1       2
   / \     / \     / \
  1   2   0   2   0   1
 /   /   /   /   /   /
2   1   2   0   1   0

*/
public class Problem24 {

    public Problem24() {
        //TODO
        checkPermutations(10);
    }

    private void checkPermutations(int amountOfDigits) {
        for (int i = 0; i < amountOfDigits; i++ ) {

        }
    }


}

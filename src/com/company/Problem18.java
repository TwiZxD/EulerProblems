package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23. (3 + 7 + 4 + 9)
 *
 *                     3
 *                    7 4
 *                   2 4 6
 *                  8 5 9 3
 *
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 *                     75
 *                    95 64
 *                   17 47 82
 *                  18 35 87 10
 *                 20 04 82 47 65
 *                19 01 23 75 03 34
 *               88 02 77 73 07 63 67
 *             99 65 04 28 06 16 70 92
 *            41 41 26 56 83 40 80 70 33
 *           41 48 72 33 47 32 37 16 94 29
 *          53 71 44 65 25 43 91 52 97 51 14
 *         70 11 33 28 77 73 17 78 39 68 17 57
 *        91 71 52 38 17 14 91 43 58 50 27 29 48
 *       63 66 04 68 89 53 67 30 73 16 69 87 40 31
 *      04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 *  NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However,
 *  Problem 67, is the same challenge with a triangle containing
 *  one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 */

public class Problem18 {
    private String stringTree  = "75\n" +
            "95 64\n" +
            "17 47 82\n" +
            "18 35 87 10\n" +
            "20 04 82 47 65\n" +
            "19 01 23 75 03 34\n" +
            "88 02 77 73 07 63 67\n" +
            "99 65 04 28 06 16 70 92\n" +
            "41 41 26 56 83 40 80 70 33\n" +
            "41 48 72 33 47 32 37 16 94 29\n" +
            "53 71 44 65 25 43 91 52 97 51 14\n" +
            "70 11 33 28 77 73 17 78 39 68 17 57\n" +
            "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
            "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    private List<Integer> valueList;
    private List<Node> tree;

    public Problem18() {
        //Put all values from the tree into a list.
        initValueList();

        //Create a tree
        createTree();

        //Do algoritm to find best path.
        System.out.println("Sum of highest path: " + findPathMaximum());
    }


    private void initValueList() {
        Scanner scanner = new Scanner(stringTree);
        valueList = new ArrayList<>();

        while (scanner.hasNextInt()) {
            valueList.add(scanner.nextInt());
        }
    }

    /*  Nodes position in the tree looks like following:
           0     level: 1
          1 2           2
         3 4 5          3
        6 7 8 9         4
     */
    private void createTree() {
        //Create all nodes for the tree and init value
        tree = new ArrayList<>();

        for (Integer i : valueList) {
            Node node = new Node(i);
            tree.add(node);
        }

        //Set up the tree.
        int level = 1;
        int nodesLeftOnRow = 1;
        for(int i = 0; i< tree.size(); i++) {
            if(nodesLeftOnRow == 0) {
                level++;
                nodesLeftOnRow = level;
            }
            if(i + level < tree.size()) {
                tree.get(i).setLeftChild(tree.get(i + level));
            }
            if(i + level + 1 < tree.size()) {
                tree.get(i).setRightChild(tree.get(i + level + 1));
            }
            nodesLeftOnRow--;
        }
    }

    private int findPathMaximum() {
        createPath(tree.get(0));

        //The memory value and path is now stored in root.
        // Since we have already calculated the sum of the path (in memory value) we don't have to go through it.
        return tree.get(0).memoryValue;
    }


    private int createPath(Node node) {
        if (node.memoryValue < 0) {
            node.memoryValue = node.value;
            int left;
            int right;

            if(node.leftChild != null ) {
                //Since the tree is full, if there are one left child there are one right child.
                left = createPath(node.leftChild);
                right = createPath(node.rightChild);
                if(left > right) {
                    node.path = node.leftChild;
                    node.memoryValue = node.memoryValue + node.leftChild.memoryValue;
                } else {
                    node.path = node.rightChild;
                    node.memoryValue = node.memoryValue + node.rightChild.memoryValue;
                }
            }
        }
        return node.memoryValue;
    }

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
        private int memoryValue; //Nodes value + value of the remaning path.
        private Node path; // Which child one should take to get the highest sum

        Node(int value) {
            this.value = value;
            this.memoryValue = -1;
        }

        private void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        private void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

}
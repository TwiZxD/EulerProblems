package com.company;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 */

public class Problem15 {
    /**
     * I use a recursive solution where I bruteforce all possible solutions.
     * The solution will create a binary tree where the amount of leaves is the answer to the problem.
     *
     * I had problems with memory when trying to solve this problem. This I solved with a memory matrix.
     * The solution to (x,y) needs the solution in (x+1, y), (x, y+1) and (x+1, y+1) and storing the solution
     * helps the speed of the algoritm tremendously.
     */
    private int maxX;
    private int maxY;
    private int startX;
    private int startY;
    private long[][] memoryMatrix; //Have to use long. Int gave negative sums which gave incorrect answer.

    Problem15() {
        //Start in top left corner
        this.startX = 0;
        this.startY = 0;
        //End in bottom right corner
        this.maxX = 20;
        this.maxY = 20;

        memoryMatrix= new long[maxX][maxY]; //Matrix with 0 as initial data.

        long sum = calculateAmoutsOfRoutes(startX, startY, maxX, maxY);
        System.out.println("Answer: " + sum);

        //printMemoryMatrix();
    }


    /** Calculates how many different routes one can take if starting in a corner of x and y and moves to the opposite corner
     * of a grid where the edge is at maxX and maxY. One can only move to the right (x+1) or down/up (y + 1)
     *
     * (x,y)_ _ _ _ _ _ _ _ _ _ _ _
     *     |_|_|_|_|_|_|_|_|_|_|_|_|
     *     |_|_|_|_|_|_|_|_|_|_|_|_|
     *     |_|_|_|_|_|_|_|_|_|_|_|_|
     *     |_|_|_|_|_|_|_|_|_|_|_|_|
     *     |_|_|_|_|_|_|_|_|_|_|_|_|
     *     |_|_|_|_|_|_|_|_|_|_|_|_|
     *                          (xMax, yMax)
     *
     * */
    private long calculateAmoutsOfRoutes(int startX, int startY, int maxX, int maxY) {
        long sum = 0;
        if(startX == maxX || startY == maxY) { //If the route have reached an edge of the grid,
            // that means it have found a complete route and we are at the leaf of the tree.
            return 1;
        }
        if(memoryMatrix[startX][startY] == 0) { //If memory is 0 means that no data have been saved.
            if(startX < maxX) {
                sum =  sum + calculateAmoutsOfRoutes(startX + 1,startY, maxX, maxY);
            }
            if(startY < maxY) {
                sum = sum + calculateAmoutsOfRoutes(startX, startY + 1, maxX,maxY);
            }
            memoryMatrix[startX][startY] = sum;
            return sum;

        } else return memoryMatrix[startX][startY];

    }

    private void printMemoryMatrix() {
        System.out.println("Memory Matrix: ");
        for(int y = startY; y<maxY;y++) {
            for(int x = startX; x<maxX; x++) {
                System.out.print(memoryMatrix[x][y] + " ");
            }
            System.out.println();
        }
    }

}

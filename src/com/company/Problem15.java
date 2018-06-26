package com.company;

public class Problem15 {
    //Recurssion

    int[][] matrix = new int[20][20];

    Problem15() {
        int startX = 0;
        int startY = 0;
        int maxX = 20;
        int maxY = 20;

        int sum = calculateAmoutsOfRoutes(startX, startY, maxX, maxY);
        System.out.println(sum);
    }
    /** Calculates how many different routes one can take if starting in a corner of x and y and moves to the opposite corner
     * of a grid where the edge is at maxX and maxY. One can only move to the right (x+1) or down/up (y + 1)
     *
     *
     * (x,y)_ _ _
     *     |_|_|_|
     *     |_|_|_|
     *           (xMax, yMax)
     *
     * */
    public int calculateAmoutsOfRoutes(int startX, int startY, int maxX, int maxY) {
        int sum = 0;
        System.out.print ("(" + startX + "," + startY + ")");
        if(startX == maxX || startY == maxY) {
            System.out.println(" ok");
            return sum + 1;
        }
        if(matrix[startX][startY] == 0) {
            if(startX < maxX) {

                sum =  sum + calculateAmoutsOfRoutes(startX + 1,startY, maxX, maxY);
            }
            if(startY < maxY) {
                sum = sum + calculateAmoutsOfRoutes(startX, startY + 1, maxX,maxY);
            }
            matrix[startX][startY] = sum;
            return sum;

        } else return matrix[startX][startY];


    }

}

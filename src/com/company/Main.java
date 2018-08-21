package com.company;

import com.company.algorithms.AlgorithmTester;
import com.company.datastructures.BinarySearchTree;
import com.company.datastructures.DatastructuresTester;
import com.company.graphics.GraphicsWindow;
import com.company.projectEuler.*;

/**
My programming solutions for euler problems found at: https://projecteuler.net/
username: twizeuler
*/
public class Main {
    public static void main(String[] args) {
        long timerStart = System.currentTimeMillis();

        /** What to do... */
        new DatastructuresTester();
//        new Problem22();

	    System.err.println("Found in: " + (System.currentTimeMillis() - timerStart) + " ms");
    }

    /** What we can do... */
    //testDrawingBinary();
    //testGraphics();
    //new AlgorithmTester();
    //new DatastructuresTester();

    /**
    * TODO Problem 22
    * TODO Problem 24
    * TODO Problem 45
    * */



    private static void testDrawingBinary() {
        BinarySearchTree tree = new BinarySearchTree<>();
        String numbers = "215847586239586518429756358564515395";
        //String numbers = "5070605565804030201041424345465447534853525109080706052523869365584920";
        for(int i = 0; i < numbers.length()/2; i++) {
            String sub = numbers.substring(i*2, (i*2)+2);
            tree.add(Integer.parseInt(sub));
        }
        GraphicsWindow renderer = new GraphicsWindow();
        renderer.drawTree(tree);
        renderer.render();
    }

    private static void testGraphics() {
        GraphicsWindow renderer = new GraphicsWindow();
        renderer.drawTree(7*2,20);
        //   renderer.drawCircle(50, 50, 50);
        //   renderer.drawText(50, 50, "5", 15);

        renderer.render();
    }
}





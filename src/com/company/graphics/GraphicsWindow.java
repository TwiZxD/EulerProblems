package com.company.graphics;

import com.company.datastructures.BinaryTree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Johan Segerlund on 2018-08-16.
 */
public class GraphicsWindow {

    private final JFrame window;
    private ArrayList<RenderInterface> shapes;
    private int windowWidth, windowHeight;

    public GraphicsWindow(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        shapes = new ArrayList<>();
        window = new JFrame();
        window.setSize(windowWidth, windowHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null); //Middle of the screen
    }

    public GraphicsWindow() {
        this(1500, 1200);
    }

    /**
     * Draws a rectangle to the JFrame window
     */
    public void drawRectangle(int xPosition, int yPosition, int widht, int height) {
        Rectangle rectangle = new Rectangle(xPosition, yPosition, widht, height);
        RectangleRenderer object = new RectangleRenderer(xPosition, yPosition, rectangle);
        shapes.add(object);
    }

    public void drawLine(int startX, int startY, int endX, int endY) {
        LineRenderer line = new LineRenderer(startX,startY, endX,endY);
        shapes.add(line);
       // RenderObject object = new RenderObject()
    }

    public void drawLine(Point start, Point end) {
        drawLine(start.x, start.y, end.x, end.y);
    }

    public void drawCircle(int x, int y, int radious) {
        CircleRenderer circle = new CircleRenderer(x, y, radious);
        shapes.add(circle);
    }


    public void drawCircle(Point p) {
        drawCircle(p.x, p.y, 20);
    }

    public void drawCircle(Point p, int radious) {
        CircleRenderer circle = new CircleRenderer(p.x, p.y, radious);
        shapes.add(circle);
    }

    public void drawText(int x, int y, String text, float fontSize) {
        TextRenderer render = new TextRenderer(x,y, text,fontSize);
        shapes.add(render);

    }

    public void drawText(Point p, String text, float fontSize) {
        TextRenderer render = new TextRenderer(p.x, p.y, text,fontSize);
        shapes.add(render);
    }

    public void drawText(Point p, String text) {
        drawText(p, text, 10);
    }

    public void drawTree(int nodes, int sizeOfNodes) {
        int space = 1;
        ArrayList<Point> nodesPosition = new ArrayList<>();
        int startX = windowWidth / 2;
        int startY = 20;
        int level = 0;
        int sizeOfText = sizeOfNodes / 2;

        int nodeOnLevelCounter = 1;
        for(int i = 0; i < nodes; i++) {
            if(nodeOnLevelCounter == 0) {
                level = level + 1;
                nodeOnLevelCounter = (int) Math.pow(2,level);
            }
            nodeOnLevelCounter--;


            Point p = new Point(startX + ((int)Math.pow(2,level)*sizeOfNodes)*space - (nodeOnLevelCounter * sizeOfNodes)*2*space
                    ,startY + (level * sizeOfNodes*3));
            drawCircle(p, sizeOfNodes);
            drawText(p, i + 1 +"", sizeOfText);

            nodesPosition.add(p);
        }

        for(int i = nodesPosition.size(); i > 1; i--) {
            Point nodePos = nodesPosition.get(i-1);
            Point parrentPosition = nodesPosition.get((i/2)-1);
            drawLine(nodePos, parrentPosition);
        }
    }

    public void drawTree(BinaryTree tree) {
        int x = windowWidth/2;
        int y = 20;
        recursiveDrawTree(tree.getRoot(),new Point (x,y),1, x);
    }

    private void recursiveDrawTree(BinaryTree.Node node,Point p, int level,int startValue) {
        if(node == null) {
            System.out.println("null node");
        } else if(node.getData() == null) {
            System.out.println("Data = null");
        } else {
            drawCircle(p);
            drawText(p, node.getData().toString() );
            if(node.getLeftChild() != null) {
                Point leftChild = new Point((int) (p.x - (startValue / Math.pow(2,level))), p.y + 50);
                drawLine(p, leftChild);
                recursiveDrawTree(node.getLeftChild(), leftChild,level + 1, startValue);
            }
            if(node.getRightChild() != null) {
                Point rightChild = new Point((int) (p.x + (startValue / Math.pow(2,level))), p.y + 50);
                drawLine(p, rightChild);
                recursiveDrawTree(node.getRightChild(), rightChild, level + 1, startValue);
            }
        }
    }

    /**
     * In order to view this window and all the objects that relates to it, this methods needs to be called once.
     * As of now, we can't move objects once they have been rendered.
     */
    public void render() {
        window.add(new Render());

        window.setVisible(true);
    }

    private class Render extends JComponent {
        Color defaultColor = Color.BLACK;
        public void paint(Graphics g) {
            for(RenderInterface object: shapes) {
                g.setColor(defaultColor);
                object.draw(g);
            }
        }
    }

}

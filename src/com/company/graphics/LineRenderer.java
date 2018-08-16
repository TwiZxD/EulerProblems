package com.company.graphics;

import java.awt.*;

/**
 * Created by Johan Segerlund on 2018-08-16.
 */
public class LineRenderer implements RenderInterface{
    private final int startX, startY, endX, endY;

    public LineRenderer(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawLine(startX, startY, endX, endY);
    }

}

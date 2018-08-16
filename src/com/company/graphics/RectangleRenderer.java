package com.company.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Johan Segerlund on 2018-08-16.
 */
public class RectangleRenderer extends JComponent implements RenderInterface {
    private final int x, y;
    private final Rectangle rectangle;

    public RectangleRenderer(int xPosition, int yPosition, Rectangle rectangle) {
        this.x = xPosition;
        this.y = yPosition;
        this.rectangle = rectangle;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.BLUE);
        g2d.translate(x, y);
        g2d.draw(rectangle);
    }

}

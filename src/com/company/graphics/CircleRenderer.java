package com.company.graphics;

import java.awt.*;

/**
 * Created by Johan Segerlund on 2018-08-16.
 */
public class CircleRenderer implements RenderInterface {

    private int x, y, radious;

    public CircleRenderer(int x, int y, int radious) {
        this.x = x;
        this.y = y;
        this.radious = radious;
    }

    public CircleRenderer(int x, int y) {
        this(x, y,20);
    }

    public void draw(Graphics g) {
        x = x-(radious/4);
        y = y-(radious/4);
        g.setColor(Color.BLACK);
        g.fillOval(x,y,radious,radious);
     //   g.drawOval(x,y, radious, radious);
    }

}

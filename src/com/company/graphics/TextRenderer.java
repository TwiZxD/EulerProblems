package com.company.graphics;

import java.awt.*;

/**
 * Created by Johan Segerlund on 2018-08-16.
 */
public class TextRenderer implements RenderInterface{
    private int x, y;
    private String text;
    float fontSize;

    public TextRenderer(int x, int y, String text) {
        this(x, y, text, 15);
    }

    public TextRenderer(int x, int y, String text, float fontSize) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.fontSize = fontSize;

    }

    public void draw(Graphics g) {
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(fontSize);
        g.setFont(newFont);
        g.setColor(Color.WHITE);
        int size = currentFont.getSize();
        text.length();
        g.drawString(text, x-(size/4) - text.length()*6/4 , y+(size/4));

    }
}

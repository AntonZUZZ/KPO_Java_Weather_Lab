package com.company;
import java.awt.*;

public class Pixel {
    private int x;
    private int y;
    private Color color;

    // Constructor
    Pixel (int x, int y, Color c)
    {
        this.x = x;
        this.y = y;
        this.color = c;
    }

    // Getters
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public Color getColor()
    {
        return color;
    }

    // Setters
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setColor(Color c)
    {
        this.color = c;
    }

    public String toString()
    {
        return color.getRed() + "." + color.getGreen() + "." + color.getBlue() + "." + x + "." + y + "\n";
    }
}

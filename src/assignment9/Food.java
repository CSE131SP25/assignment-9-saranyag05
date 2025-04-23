package assignment9;

import java.awt.Color;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Food {

    public static final double FOOD_SIZE = 0.02;
    private double x, y;
    private Color color;

    public Food() {
        respawn();
    }

    public void respawn() {
        Random random = new Random();
        x = random.nextDouble();
        y = random.nextDouble();
        color = ColorUtils.solidColor();
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, FOOD_SIZE);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

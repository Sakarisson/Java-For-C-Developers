package dt062g.krsa1201.assignment2;

import java.awt.Graphics;

/**
 * <h1>Shape</h1>
 * <p>An abstract superclass defining different
 * geometric shapes</p>
 * <p>Implements Drawable</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 */
public class Shape implements Drawable {

    private Point _point;
    private String _color;

    /**
     * <h2>Raw coordinate constructor</h2>
     * <p>Constructs shape from raw x and y value</p>
     * @param x double
     * @param y double
     * @param color String
     */
    public Shape(double x, double y, String color) {
        _point = new Point(x, y);
        _color = color;
    }

    /**
     * <h2>Point-based constructor</h2>
     * <p>Constructs shape from point</p>
     * @param point Point
     * @param color String
     */
    public Shape(Point point, String color) {
        _point = point;
        _color = color;
    }

    public void draw() {

    }

    public void draw(Graphics g) {

    }
}

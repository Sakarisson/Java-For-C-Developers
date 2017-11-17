package dt062g.krsa1201.assignment4;

import java.util.ArrayList;

/**
 * <h1>Shape</h1>
 * <p>An abstract superclass defining different
 * geometric shapes</p>
 * <p>Implements Drawable</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 3.0
 * @since 08-11-2017
 */
abstract class Shape implements Drawable {

    // Inheritable datamembers
    protected ArrayList<Point> _points = new ArrayList<Point>();
    protected String _color;

    /**
     * <h2>Raw coordinate constructor</h2>
     * <p>Constructs shape from raw x and y value</p>
     * @param x double
     * @param y double
     * @param color String
     * @since 3.0
     */
    public Shape(double x, double y, String color) {
        this._points.add(new Point(x, y));
        this._color = color;
    }

    /**
     * <h2>Point-based constructor</h2>
     * <p>Constructs shape from point</p>
     * @param point Point
     * @param color String
     * @since 3.0
     */
    public Shape(Point point, String color) {
        this._points.add(point);
        this._color = color;
    }

    /**
     * <h2>Get circumference</h2>
     * <p>Get circumference of shape</p>
     * <p>Abstract function. Different implementations for
     * different shapes.</p>
     * @return Circumference in units
     */
    abstract public double getCircumference() throws ShapeException;

    /**
     * <h2>Get area</h2>
     * <p>Get area of shape</p>
     * <p>Abstract function. Different implementations for
     * different shapes.</p>
     * @return Area in square units
     */
    abstract public double getArea() throws ShapeException;

    /**
     * <h2>Add point</h2>
     * <p>Change second point of shape by raw coordinates</p>
     * @param x double
     * @param y double
     * @since 3.0
     */
    public void addPoint(double x, double y) {
        if (this._points.size() < 2) {
            this._points.add(new Point(x, y));
        }
    }

    /**
     * <h2>Add point</h2>
     * <p>Change second point of shape by Point object</p>
     * @param point Point
     */
    public void addPoint(Point point) {
        if (this._points.size() < 2) {
            this._points.add(point);
        }
    }
}

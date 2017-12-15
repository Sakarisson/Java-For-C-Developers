package dt062g.krsa1201.assignment7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <h2>Point</h2>
 * <p>The class point, used for defining the
 * geometric location of a given shape</h2>
 * @author Kristian Sakarisson (krsa1201)
 * @version 2.0
 * @since 20-11-2017
 */
@XmlRootElement(name = "point")
@XmlAccessorType(XmlAccessType.FIELD)
final class Point {

    @XmlElement(name = "x")
    private double _x;
    @XmlElement(name = "y")
    private double _y;

    /**
     * <h2>Default constructor</h2>
     * <p>Sets coordinates to 0,0</p>
     */
    public Point() {
        _x = 0;
        _y = 0;
    }

    /**
     * <h2>Coordinate constructor</h2>
     * <p>Constructs point from x and y coordinates</p>
     * @param x double
     * @param y double
     */
    public Point(double x, double y) {
        _x = x;
        _y = y;
    }

    /**
     * <h2>Get x</h2>
     * <p>Get x-coordinate of point</p>
     * @return x-coordinate
     */
    public double x() {
        return _x;
    }

    /**
     * <h2>Get y</h2>
     * <p>Get y-coordinate of point</p>
     * @return y-coordinate
     */
    public double y() {
        return _y;
    }

    /**
     * <h2>Set x</h2>
     * <p>Set x-coordinate of point</p>
     * @param x double
     */
    public void setX(double x) {
        _x = x;
    }

    /**
     * <h2>Set y</h2>
     * <p>Set y-coordinate of point</p>
     * @param y double
     */
    public void setY(double y) {
        _y = y;
    }

    /**
     * <h2>toString()</h2>
     * <p>Override toString() method to simply return the coordinates
     * as a string</p>
     * @return Coordinates in the format : x, y
     */
    public String toString() {
        return _x + ", " + _y;
    }
}

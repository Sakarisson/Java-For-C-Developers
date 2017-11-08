package dt062g.krsa1201.assignment2;

/**
 * <h2>Point</h2>
 * <p>The class point, used for defining the
 * geometric location of a given shape</h2>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 */
public class Point {

    private double _x;
    private double _y;

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
}

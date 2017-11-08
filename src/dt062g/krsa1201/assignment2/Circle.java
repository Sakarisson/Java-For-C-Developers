package dt062g.krsa1201.assignment2;

/**
 * <h1>Circle</h1>
 * <p>The class is derived from Shape</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 */
class Circle extends Shape {

    /**
     * <h2>Circle coordinate constructor</h2>
     * <p>Calls coordinate constructor of Shape</p>
     */
    Circle(double x, double y, String color) {
        super(x, y, color);
    }
    
    /**
     * <h2>Circle Point constructor</h2>
     * <p>Calls Point constructor of Shape</p>
     */
    Circle(Point point, String color) {
        super(point, color);
    }
}

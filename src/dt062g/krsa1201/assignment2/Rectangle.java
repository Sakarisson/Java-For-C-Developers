package dt062g.krsa1201.assignment2;

/**
 * <h1>Rectangle</h1>
 * <p>The class is derived from Shape</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 */
class Rectangle extends Shape {

    /**
     * <h2>Rectangle coordinate constructor</h2>
     * <p>Calls coordinate constructor of Shape</p>
     */
    Rectangle(double x, double y, String color) {
        super(x, y, color);
    }
    
    /**
     * <h2>Rectangle Point constructor</h2>
     * <p>Calls Point constructor of Shape</p>
     */
    Rectangle(Point point, String color) {
        super(point, color);
    }
}

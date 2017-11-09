package dt062g.krsa1201.assignment2;

import java.awt.Graphics;

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

    // Inherited
    public double getCircumference() {
        return 2;
    }

    // Inherited
    public double getArea() {
        return 1;
    }

    public double getWidth() {
        double width = Math.abs(this._points[0].x() - this._points[1].x());
        return width;
    }

    public double getHeight() {
        double height = Math.abs(this._points[0].y() - this._points[1].y());
        return height;
    }

    /**
     * <h2>Draw override</h2>
     */
    public void draw() {
        System.out.println("Drawing a Rectangle" + this.toString());
    }

    /**
     * <h2>Draw override</h2>
     */
    public void draw(Graphics g) {
        
    }

    // Override of toString() method
    public String toString() {
        String output = "[";
        output += "start=" + this._points[0].toString() + "; ";
        output += "end=" + this._points[1].toString() + "; ";
        output += "width=" + this.getWidth() + "; ";
        output += "height=" + this.getHeight() + "; ";
        output += "color=" + this._color + "]";

        return output;
    }
}

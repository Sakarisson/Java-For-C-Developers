package dt062g.krsa1201.assignment3;

import java.awt.Graphics;

/**
 * <h1>Rectangle</h1>
 * <p>The class is derived from Shape</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 08-11-2017
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
        if (this.getWidth() >= 0 && this.getHeight() >= 0) {
            return 2 * (this.getWidth() + this.getHeight()); // C = 2(w+h)
        } else {
            return -1;
        }
    }

    // Inherited
    public double getArea() {
        if (this.getWidth() >= 0 && this.getHeight() >= 0) {
            return this.getWidth() * this.getHeight(); // A = wh
        } else {
            return -1;
        }
    }

    /**
     * <h2>Get width</h2>
     * <p>Calculates the width of square. Returns
     * -1 if square doesn't have any width (i.e. there is no second
     * point)</p>
     * @return Width of square or -1
     */
    public double getWidth() {
        double width;
        try {
            width = Math.abs(this._points[0].x() - this._points[1].x());
        } catch (Exception e) {
            width = -1;
        }
        return width;
    }

    /**
     * <h2>Get height</h2>
     * <p>Calculates height of square. Returns
     * -1 if square doesn't have any height (i.e. there is no second
     * point)</p>
     * @return Height of square or -1
     */
    public double getHeight() {
        double height;
        try {
            height = Math.abs(this._points[0].y() - this._points[1].y());
        } catch (Exception e) {
            height = -1;
        }
        return height;
    }

    /**
     * <h2>Draw override</h2>
     * <p>"Writes" square in the sense that it prints some information about
     * the square</p>
     */
    public void draw() {
        System.out.println("Drawing a Rectangle" + this.toString());
    }

    /**
     * <h2>Draw override</h2>
     * <p>Not implemented in assignment 2</p>
     * @param g Graphics
     */
    public void draw(Graphics g) {
        
    }

    // Override of toString() method
    public String toString() {
        String output = "[";
        output += "start=" + this._points[0].toString() + "; ";
        output += "end=";
        try {
            output += this._points[1].toString();
        } catch (Exception e) { // Null reference error if there is no second point
            output += "N/A";
        }
        output += "; width="; 
        output += this.getWidth() >= 0 ? this.getWidth() : "N/A";    // Write width if non-negative, else N/A
        output += "; height=";
        output += this.getHeight() >= 0 ? this.getHeight() : "N/A";  // Write height if non-negative, else N/A
        output += "; color=" + this._color + "]";

        return output;
    }
}

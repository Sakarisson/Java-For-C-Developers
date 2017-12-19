package dt062g.krsa1201.assignment7;

import java.awt.Color;
import java.awt.Graphics;
import java.nio.channels.ShutdownChannelGroupException;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <h1>Rectangle</h1>
 * <p>The class is derived from Shape</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 4.0
 * @since 20-11-2017
 */
@XmlRootElement(name = "rectangle")
final class Rectangle extends Shape {

    /**
     * <h2>Default constructor</h2>
     * <p>Calls default constructor of Shape</p>
     * @since 4.0
     */
    public Rectangle() {
        super();
    }

    /**
     * <h2>Rectangle coordinate constructor</h2>
     * <p>Calls coordinate constructor of Shape</p>
     */
    public Rectangle(double x, double y, String color) {
        super(x, y, color);
    }
    
    /**
     * <h2>Rectangle Point constructor</h2>
     * <p>Calls Point constructor of Shape</p>
     */
    public Rectangle(Point point, String color) {
        super(point, color);
    }

    // Inherited
    public double getCircumference() throws ShapeException {
        try {
            return 2 * (this.getWidth() + this.getHeight()); // C = 2(w+h)
        } catch (ShapeException e) {
            throw new ShapeException("The circumference cannot be calculated, end point is missing");
        }
    }

    // Inherited
    public double getArea() throws ShapeException {
        double area = 0;
        try {
            area = this.getWidth() * this.getHeight(); // A = wh
        } catch (ShapeException e) {
            throw new ShapeException("The area cannot be calculated, end point is missing");
        }
        return area;
    }

    /**
     * <h2>Get width</h2>
     * <p>Calculates the width of square.</p>
     * @return Width of square or ShapeException
     */
    public double getWidth() throws ShapeException {
        try {
            return  Math.abs(this._points.get(0).x() - this._points.get(1).x());
        } catch (Exception e) {
            throw new ShapeException("Could not determine width of square. End point missing");
        }
    }

    /**
     * <h2>Get height</h2>
     * <p>Calculates height of square.</p>
     * @return Height of square or ShapeException
     */
    public double getHeight() throws ShapeException {
        try {
            return Math.abs(this._points.get(0).y() - this._points.get(1).y());
        } catch (Exception e) {
            throw new ShapeException("Could not determine height of square. End point missing");
        }
    }

    /**
     * <h2>Draw override</h2>
     * <p>"Writes" square in the sense that it prints some information about
     * the square</p>
     * @since 3.0
     */
    public void draw() {
        System.out.println("Drawing a Rectangle" + this);
    }

    /**
     * <h2>Draw override</h2>
     * <p>Rectangles get drawn from the top left point and they have a certain width and height.
     * It is necessary to first find the top left point, and then calculate the width and height.</p>
     * <p>After this, the square gets drawn</p>
     * @param g Graphics
     */
    public void draw(Graphics g) {
        try {
            Point topLeft = new Point();
            Point bottomRight = new Point();
            if (this._points.get(0).x() < this._points.get(1).x()) {
                topLeft.setX(this._points.get(0).x());
                bottomRight.setX(this._points.get(1).x());
            } else {
                topLeft.setX(this._points.get(1).x());
                bottomRight.setX(this._points.get(0).x());
            }
            if (this._points.get(0).y() < this._points.get(1).y()) {
                topLeft.setY(this._points.get(0).y());
                bottomRight.setY(this._points.get(1).y());
            } else {
                topLeft.setY(this._points.get(1).y());
                bottomRight.setY(this._points.get(0).y());
            }
            int width = Math.abs((int)bottomRight.x() - (int)topLeft.x());
            int height = Math.abs((int)bottomRight.y() - (int)topLeft.y());
            g.setColor(Color.decode(this._color));
            g.fillRect((int)topLeft.x(), (int)topLeft.y(), width, height);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Override of toString() method
    public String toString() {
        String output = "[";
        output += "start=" + this._points.get(0) + "; ";
        output += "end=";
        try {
            output += this._points.get(1);
        } catch (Exception e) { // Null reference error if there is no second point
            output += "N/A";
        }
        output += "; width="; 
        try {
            output += this.getWidth();
        } catch (ShapeException e) {
            output += "N/A";
        }
        output += "; height=";
        try {
            output += this.getHeight();
        } catch (ShapeException e) {
            output += "N/A";
        }
        output += "; color=" + this._color + "]";

        return output;
    }
}

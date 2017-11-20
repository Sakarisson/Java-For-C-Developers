package dt062g.krsa1201.assignment5;

import java.awt.Graphics;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <h1>Circle</h1>
 * <p>The class is derived from Shape</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 4.0
 * @since 20-11-2017
 */
@XmlRootElement(name = "circle")
final class Circle extends Shape {

    /**
     * <h2>Default constructor</h2>
     * <p>Calls default constructor of Shape</p>
     * @since 4.0
     */
    public Circle() {
        super();
    }

    /**
     * <h2>Circle coordinate constructor</h2>
     * <p>Calls coordinate constructor of Shape</p>
     */
    public Circle(double x, double y, String color) {
        super(x, y, color);
    }
    
    /**
     * <h2>Circle Point constructor</h2>
     * <p>Calls Point constructor of Shape</p>
     */
    public Circle(Point point, String color) {
        super(point, color);
    }

    /**
     * <h2>Get radius</h2>
     * <p>Function used to get the radius
     * of circle object</p>
     * @return Radius of this or ShapeException
     */
    public double getRadius() throws ShapeException {
        try {
            // Get difference between x and y positions
            double xDifference = Math.abs(this._points.get(0).x() - this._points.get(1).x());       // Length from center to point on circle, along the x-axis
            double yDifference = Math.abs(this._points.get(0).y() - this._points.get(1).y());       // Length from center to point on circle, along the y-axis
            double radius = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2)); // Use Pythagoras theorem to find radius
            return radius;
        } catch (Exception e) {
            throw new ShapeException("Radius could not be determined, end point missing!");
        }
    }

    // Inherited
    public double getCircumference() throws ShapeException {
        try {
            return 2 * Math.PI * this.getRadius(); // C = 2πr
        } catch (ShapeException e) {
            throw new ShapeException("Circumference could not be determined, end point missing!");
        }
    }

    // Inherited
    public double getArea()throws ShapeException {
        try {
            return Math.PI * Math.pow(this.getRadius(), 2); // A = πr^2
        } catch (ShapeException e) {
            throw new ShapeException("The area cannot be calculated, end point is missing");
        }
    }

    /**
     * <h2>Draw override</h2>
     * <p>"Writes" circle in the sense that it prints some information about
     * the circle</p>
     * @since 3.0
     */
    public void draw() {
        System.out.println("Drawing a Circle" + this);
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
        output += "start=" + this._points.get(0) + "; ";
        output += "end=";
        try {
            output += this._points.get(1);
        } catch (Exception e) { // Null reference if there is no second point
            output += "N/A";
        }
        output += "; radius=";
        try {
            output += this.getRadius() + "; ";
        } catch (ShapeException e) {
            output += "N/A; ";
        }
        output += "color=" + this._color + "]";

        return output;
    }
}

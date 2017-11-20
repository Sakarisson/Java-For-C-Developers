package dt062g.krsa1201.assignment5;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Drawing</h1>
 * <p>Implementation of the Drawing class, which includes information
 * about a drawing, such as author name, name of drawing and a List
 * of Shapes</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 15-11-2017
 */
class Drawing implements Drawable {

    // Private data members
    private String _name;
    private String _author;
    private List<Shape> _shapes;

    /**
     * <h2>Default constructor</h2>
     * <p>Instantiates a new Drawing with no name or known author</p>
     */
    public Drawing() {
        this._name = "";
        this._author = "";
        this._shapes = new ArrayList<Shape>();
    }

    /**
     * <h2>Parameter constructor</h2>
     * <p>Instantiates a new Drawing with a set name and author</p>
     * @param name The name of the drawing
     * @param author The author's name
     */
    public Drawing(String name, String author) {
        this._name = name;
        this._author = author;
        this._shapes = new ArrayList<Shape>();
    }

    /**
     * <h2>Set name</h2>
     * <p>Set the name of the drawing</p>
     * @param name The name of the drawing
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * <h2>Get name</h2>
     * <p>Get the name of the drawing</p>
     * @return Name of drawing
     */
    public String getName() {
        return this._name;
    }

    /**
     * <h2>Set author</h2>
     * <p>Sets the name of the author of the drawing</p>
     * @param name The author's name
     */
    public void setAuthor(String name) {
        this._author = name;
    }

    /**
     * <h2>Get author</h2>
     * <p>Returns the name of the author of the drawing</p>
     * @return The author's name
     */
    public String getAuthor() {
        return this._author;
    }

    /**
     * <h2>Add shape</h2>
     * <p>Add a given shape to the List of shapes</p>
     * <p>Adds if input shape is not null</p>
     * @param shape The shape to be added
     */
    public void addShape(Shape shape) {
        if (shape != null) {
            this._shapes.add(shape);
        }
    }

    /**
     * <h2>Get size</h2>
     * <p>Get the number of shapes currently in drawing</p>
     * @return The number of shapes
     */
    public int getSize() {
        return this._shapes.size();
    }

    /**
     * <h2>Get total circumference</h2>
     * <p>Get the total circumference of all shapes in
     * drawing. Only applies to shapes that actually have a circumference</p>
     * @return The total circumference
     */
    public double getTotalCircumference() {
        double total = 0;
        for (Shape s: this._shapes) {
            try {
                total += s.getCircumference();
            } catch (ShapeException e) {
                // Continue without doing anything...
            }
        }
        return total;
    }

    /**
     * <h2>Get total area</h2>
     * <p>Get the total area of all shapes in drawing.
     * Only applies to shapes that actually have an area</p>
     * @return The total area
     */
    public double getTotalArea() {
        double total = 0;
        for (Shape s: this._shapes) {
            try {
                total += s.getArea();
            } catch (ShapeException e) {
                // Continue without doing anything...
            }
        }
        return total;
    }

    /**
     * <h2>Draw</h2>
     * <p>"Draws" all shapes by printing various information about them</p>
     */
    public void draw() {
        String description = "A drawing by " + this.getAuthor() + " called " + this.getName();
        System.out.println(description);
        for (Shape s: this._shapes) {
            System.out.println(s.getClass().getSimpleName() + s);
        }
    }

    /**
     * <h2>Graphics draw</h2>
     * <p>Draw all graphics</p>
     * <p>Not implemented in assignment 4</p>
     */
    public void draw(Graphics g) {

    }

    /**
     * <h2>toString()</h2>
     * <p>Override of toString() method</p>
     * <p>Writes information about name, author, size,
     * circumference and area</p>
     * @return String with information about drawing
     */
    public String toString() {
        String output = "";

        output += "Drawing[";
        output += "name=" + this.getName() + "; ";
        output += "author=" + this.getAuthor() + "; ";
        output += "size=" + this.getSize() + "; ";
        output += "circumference=" + this.getTotalCircumference() + "; ";
        output += "area=" + this.getTotalArea() + "]";

        return output;
    }
}

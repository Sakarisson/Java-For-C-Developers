package dt062g.krsa1201.assignment7;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * <h1>DrawingPanel</h1>
 * <p>An implenentation of the class described in Assignment 7, inherits
 * from JPanel. Gets used by Interface</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 15-12-2017
 */
class DrawingPanel extends JPanel {

    // Private variables
    private Drawing _drawing = new Drawing();

    /**
     * <h2>Default constructor</h2>
     * <p>Creates empty drawing object</p>
     */
    public DrawingPanel() {
        this._drawing = new Drawing();
    }

    /**
     * <h2>Parameter constructor</h2>
     * <p>Creates new drawing object based on input drawing</p>
     */
    public DrawingPanel(Drawing drawing) {
        this._drawing = drawing;
    }

    /**
     * <h2>Set drawing</h2>
     * <p>Defines drawing object that should be shown</p>
     */
    public void setDrawing(Drawing drawing) {
        this._drawing = drawing;
    }

    /**
     * <h2>Add drawing</h2>
     * <p>adds all shapes from the Drawing, that is sent as an argument to the method, into the current Drawing.</p>
     * <p>In other words, the method will be used to add or put together two different Drawing-objects.</p>
     * <p>The name and author of the Drawing will be the same as the first one.</p>
     */
    public void addDrawing(Drawing drawing) {

    }

    /**
     * <h2>Get drawing</h2>
     * <p>Returns the current drawing</p>
     */
    public Drawing getDrawing() {
        return this._drawing;
    }

    /**
     * <h2>Paint component override</h2>
     * <p>Override the paintComponent(Graphics)method, and in this the current Drawing will be drawn by calling its method draw(Graphics).</p>
     * <p>This will now call the respective figure's draw(Graphics)-method. If Drawing does not refer to something (i.e. it is null), nothing should be drawn. The background should always be white.</p>
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this._drawing.draw(g);
    }

    public void reset() {

    }
}

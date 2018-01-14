package dt062g.krsa1201.assignment8;

import java.awt.Graphics;

/**
 * <h1>Drawable</h1>
 * <p>Interface used for drawing shapes</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 08-11-2017
 */
public interface Drawable {

    /**
     * <h2>Default draw function</h2>
     * <p>"Virtual" draw function in the sense that it doesn't actually
     * do any graphical processing. Instead it simply writes to console
     * what was "drawn".</p>
     */
    public void draw();

    /**
     * <h2>Graphics draw function</h2>
     * <p>Draws a graphic</h2>
     * @param g Graphics
     */
    public void draw(Graphics g);
}

package dt062g.krsa1201.assignment6;

// import javax.swing.JFrame;
// import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <h1>Interface</h1>
 * <p>A class that controls the main window of the user interface</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 22-11-2017
 */
class Interface {

    // Private variables
    private JFrame _frame;

    /**
     * <h1>Default constructor</h1>
     * <p>Creates a new Interface class with no data already in it</p>
     */
    public Interface() {
        this._frame = new JFrame();
        this.Initialize();
    }

    /**
     * <h1>Name parameter constructor</h1>
     * <p>Creates a new Interface with a given name</p>
     */
    public Interface(String name) {
        this._frame = new JFrame(name);
        this.Initialize();
    }

    /**
     * <h2>Initialize</h2>
     * <p>Sets up the window to become a proper GUI</p>
     */
    private void Initialize() {
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this._frame.getContentPane().add(new JLabel("Kristian"), BorderLayout.CENTER);
        this._frame.pack();
        this._frame.setVisible(true);
    }
}

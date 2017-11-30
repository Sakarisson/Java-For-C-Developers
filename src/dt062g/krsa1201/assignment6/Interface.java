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
    private Color[] _colors = { 
        Color.green, 
        Color.blue, 
        Color.black, 
        Color.red, 
        Color.yellow 
    };

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
     * <h2>Create Menu</h2>
     * <p>Creates the top menu bar of the program</h2>
     */
    private void CreateMenu() {
        // Create Menu
        JMenuBar menuBar = new JMenuBar();

        // Create File menu option
        JMenu file = new JMenu("File");

        JMenuItem fileNew = new JMenuItem("New...");
        file.add(fileNew);

        JMenuItem fileSaveAs = new JMenuItem("Save As...");
        file.add(fileSaveAs);

        JMenuItem fileLoad = new JMenuItem("Load...");
        file.add(fileLoad);

        file.addSeparator();

        JMenuItem fileExit = new JMenuItem("Exit");
        file.add(fileExit);

        // Create Edit menu option
        JMenu edit = new JMenu("Edit");

        JMenuItem editUndo = new JMenuItem("Undo");
        edit.add(editUndo);

        JMenuItem editName = new JMenuItem("Name...");
        edit.add(editName);

        JMenuItem editAuthor = new JMenuItem("Author...");
        edit.add(editAuthor);

        // Add menus
        menuBar.add(file);
        menuBar.add(edit);

        // Set menu to main frame
        this._frame.setJMenuBar(menuBar);
    }

    /**
     * <h2>Initialize</h2>
     * <p>Sets up the window to become a proper GUI</p>
     */
    private void Initialize() {
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CreateMenu();
        JPanel shapePickGrid = new JPanel(new GridLayout());
        shapePickGrid.setPreferredSize(new Dimension(this._frame.getSize().width, 40));

        for (Color c: this._colors) {
            JPanel colorOption = new JPanel();
            colorOption.setBackground(c);
            shapePickGrid.add(colorOption);
        }
        String[] shapes = { "Rectangle", "Circle" };
        JComboBox<String> shapePicker = new JComboBox<String>(shapes);
        shapePickGrid.add(shapePicker);
        this._frame.add(shapePickGrid, BorderLayout.PAGE_START);
        this._frame.pack();
        this._frame.setVisible(true);
    }
}

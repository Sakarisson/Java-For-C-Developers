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
 * @since 14-12-2017
 */
class Interface implements ActionListener, MouseListener, MouseMotionListener {

    // Private variables
    private JFrame _frame;
    private String _appTitle = "Drawing Program";
    private Color[] _colorOptions = { 
        Color.green, 
        Color.blue, 
        Color.black, 
        Color.red, 
        Color.yellow,
        Color.cyan
    };
    private Drawing _drawing = new Drawing();

    // MenuBar
    JMenuBar menuBar;
    JMenu file;
    JMenuItem fileNew;
    JMenuItem fileSaveAs;
    JMenuItem fileLoad;
    JMenuItem fileExit;
    JMenu edit;
    JMenuItem editUndo;
    JMenuItem editName;
    JMenuItem editAuthor;

    // Status panel
    JPanel statusBar;
    JTextArea coordinates;
    JPanel selectedColor;

    // Drawing board
    JPanel drawingBoard;

    // Empty mouse-related implementations:
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}

    /**
     * <h1>Mouse Clicked event</h1>
     * <p>Override of the mouse clicked event, triggered whenever
     * user presses a color option</p>
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Component source = e.getComponent();
        selectedColor.setBackground(source.getBackground());
    }

    /**
     * <h1>Mouse Moved event</h1>
     * <p>Override of mouse moved event. Triggered whenever the mouse moves
     * above drawing pane</p>
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        coordinates.setText("Coordinates: " + e.getX() + ", " + e.getY());
    }

    /**
     * <h1>Create new</h1>
     * <p>Creates new drawing</p>
     */
    private void createNew() {
        String name = JOptionPane.showInputDialog("Enter name of the drawing:");
        String author = JOptionPane.showInputDialog("Enter author of the drawing:");
        _drawing = new Drawing(name, author);
        resetFrame();
    }

    /**
     * <h1>Save file</h2>
     * <p>Saves drawing to file</p>
     */
    private void saveFile() {
        JOptionPane.showInputDialog("Save drawing to:", this._drawing.getFullName() + ".xml");
    }

    /**
     * <h1>Load file</h1>
     * <p>Loads drawing from file</p>
     */
    private void loadFile() {
        JOptionPane.showInputDialog("Load drawing from:");
    }

    /**
     * <h1>ActionPerformed override</h1>
     * <p>
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object origin = e.getSource();
        if (origin == fileNew) {
            createNew();
        } else if (origin == fileSaveAs) {
            saveFile();
        } else if (origin == fileLoad) {
            loadFile();
        } else if (origin == fileExit) {
            _frame.dispatchEvent(new WindowEvent(_frame, WindowEvent.WINDOW_CLOSING)); // Dispatch close window event
        } else if (origin == editUndo) {

        } else if (origin == editName) {

        } else if (origin == editAuthor) {

        }
    }

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
        this._frame = new JFrame();
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
        file = new JMenu("File");

        fileNew = new JMenuItem("New...");
        fileNew.addActionListener(this);
        file.add(fileNew);

        fileSaveAs = new JMenuItem("Save As...");
        fileSaveAs.addActionListener(this);
        file.add(fileSaveAs);

        fileLoad = new JMenuItem("Load...");
        fileLoad.addActionListener(this);
        file.add(fileLoad);

        file.addSeparator();

        fileExit = new JMenuItem("Exit");
        fileExit.addActionListener(this);
        file.add(fileExit);

        // Create Edit menu option
        edit = new JMenu("Edit");

        editUndo = new JMenuItem("Undo");
        editUndo.addActionListener(this);
        edit.add(editUndo);

        editName = new JMenuItem("Name...");
        editName.addActionListener(this);
        edit.add(editName);

        editAuthor = new JMenuItem("Author...");
        editAuthor.addActionListener(this);
        edit.add(editAuthor);

        // Add menus
        menuBar.add(file);
        menuBar.add(edit);

        // Set menu to main frame
        this._frame.setJMenuBar(menuBar);
    }

    private void CreateColorPicker() {
        JPanel shapePickGrid = new JPanel(new GridLayout());
        shapePickGrid.setPreferredSize(new Dimension(this._frame.getSize().width, 40));
        for (Color c: this._colorOptions) {
            JPanel colorOption = new JPanel();
            colorOption.setBackground(c);
            shapePickGrid.add(colorOption);
            colorOption.addMouseListener(this);
        }
        String[] shapes = { "Rectangle", "Circle" };
        JComboBox<String> shapePicker = new JComboBox<String>(shapes);
        shapePickGrid.add(shapePicker);
        this._frame.add(shapePickGrid, BorderLayout.PAGE_START);
    }

    private void CreateDrawingBoard() {
        drawingBoard = new JPanel();
        drawingBoard.addMouseMotionListener(this);
        drawingBoard.setPreferredSize(new Dimension(500, 500));
        this._frame.add(drawingBoard);
    }

    private void CreateStatusBar() {
        JPanel statusBar = new JPanel();
        statusBar.setLayout(new BoxLayout(statusBar, BoxLayout.X_AXIS));
        coordinates = new JTextArea();
        JPanel selectedColorContainer = new JPanel();
        JTextArea colorText = new JTextArea();
        colorText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        colorText.setText("Selected color");
        selectedColorContainer.add(colorText);
        selectedColorContainer.add(selectedColor);
        statusBar.add(coordinates, BorderLayout.PAGE_START);
        statusBar.add(selectedColorContainer, BorderLayout.PAGE_END);
        this._frame.add(statusBar, BorderLayout.PAGE_END);
    }

    private void resetFrame() {
        this._frame.setTitle(this._appTitle + " - " + this._drawing.getFullName());
    }

    /**
     * <h2>Initialize</h2>
     * <p>Sets up the window to become a proper GUI</p>
     */
    private void Initialize() {
        selectedColor = new JPanel();
        selectedColor.setBackground(Color.black);
        resetFrame();
        this._frame.setSize(500, 500);
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CreateMenu();
        CreateColorPicker();
        CreateDrawingBoard();
        CreateStatusBar();
        this._frame.pack();
        this._frame.setVisible(true);
    }
}

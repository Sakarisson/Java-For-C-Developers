package dt062g.krsa1201.assignment8;

// import javax.swing.JFrame;
// import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <h2>Interface</h2>
 * <p>A class that controls the main window of the user interface</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 2.0
 * @since 18-12-2017
 */
class Interface implements ActionListener, MouseListener, MouseMotionListener {

    // Private variables
    private JFrame _frame;
    private FileHandler _fileHandler = new FileHandler();
    private String _appTitle = "Drawing Program";
    private Color[] _colorOptions = { 
        Color.green, 
        Color.blue, 
        Color.black, 
        Color.red, 
        Color.yellow,
        Color.cyan
    };
    // private Drawing _drawing = new Drawing();

    // MenuBar
    JMenuBar menuBar;
    JMenu file;
    JMenuItem fileNew;
    JMenuItem fileSaveAs;
    JMenuItem fileLoad;
    JMenuItem fileInfo;
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
    DrawingPanel drawingPanel = new DrawingPanel();

    /**
     * <h2>Default constructor</h2>
     * <p>Creates a new Interface class with no data already in it</p>
     */
    public Interface() {
        this._frame = new JFrame();
        this.Initialize();
    }

    /**
     * <h2>Name parameter constructor</h2>
     * <p>Creates a new Interface with a given name</p>
     */
    public Interface(String name) {
        this._frame = new JFrame();
        this.Initialize();
    }

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
     * <h2>Mouse Clicked event</h2>
     * <p>Override of the mouse clicked event, triggered whenever
     * user presses a color option</p>
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Component source = e.getComponent();
        selectedColor.setBackground(source.getBackground());
    }

    /**
     * <h2>Mouse Moved event</h2>
     * <p>Override of mouse moved event. Triggered whenever the mouse moves
     * above drawing pane</p>
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        coordinates.setText("Coordinates: " + e.getX() + ", " + e.getY());
    }

    /**
     * <h2>Create new</h2>
     * <p>Creates new drawing</p>
     */
    private void createNew() {
        String name = JOptionPane.showInputDialog(this._frame, "Enter name of the drawing:");
        String author = JOptionPane.showInputDialog(this._frame, "Enter author of the drawing:");
        this.drawingPanel.setDrawing(new Drawing(name, author));
        resetFrame();
    }

    /**
     * <h2>Save file</h2>
     * <p>Saves drawing to file</p>
     */
    private void saveFile() {
        String fileName = JOptionPane.showInputDialog(this._frame, "Save drawing to:", this.drawingPanel.getDrawing().getFullName() + ".xml");
        Drawing drawing = this.drawingPanel.getDrawing();
        this._fileHandler.saveToXML(drawing, fileName);
    }

    /**
     * <h2>Load file</h2>
     * <p>Loads drawing from file</p>
     */
    private void loadFile() {
        String fileName = JOptionPane.showInputDialog(this._frame, "Load drawing from:");
        this.drawingPanel.setDrawing(this._fileHandler.loadFromXML(fileName));
        resetFrame();
    }

    /**
     * <h2>Info</h2>
     * <p>Writes out info of drawing</h2>
     */
    private void fileInfo() {
        Drawing drawing = this.drawingPanel.getDrawing();
        String name = drawing.getFullName();
        int numberOfShapes = drawing.getNumberOfShapes();
        double area = drawing.getTotalArea();
        double circumference = drawing.getTotalCircumference();
        String message = 
            name + "\n" +
            "Number of shapes: " + numberOfShapes + "\n" +
            "Total area: " + area + "\n" +
            "Total circumference: " + circumference;
        JOptionPane.showMessageDialog(this._frame, message);
    }

    /**
     * <h2>Edit name</h2>
     * <p>Updates names of drawing</p>
     */
    private void editName() {
        String name = JOptionPane.showInputDialog(this._frame, "Enter name:");
        this.drawingPanel.getDrawing().setName(name);
        resetFrame();
    }

    /**
     * <h2>Edit author</h2>
     * <p>Updates author of drawing</p>
     */
    private void editAuthor() {
        String author = JOptionPane.showInputDialog(this._frame, "Enter author:");
        this.drawingPanel.getDrawing().setAuthor(author);
        resetFrame();
    }

    /**
     * <h2>ActionPerformed override</h2>
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
        } else if (origin == fileInfo) {
            fileInfo();
        } else if (origin == fileExit) {
            _frame.dispatchEvent(new WindowEvent(_frame, WindowEvent.WINDOW_CLOSING)); // Dispatch close window event
        } else if (origin == editUndo) {
            // Do nothing...
        } else if (origin == editName) {
            editName();
        } else if (origin == editAuthor) {
            editAuthor();
        }
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

        fileInfo = new JMenuItem("Info");
        fileInfo.addActionListener(this);
        file.add(fileInfo);

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

    /**
     * <h2>Create color picker</h2>
     * <p>Creates color picker and adds it to frame</p>
     */
    private void CreateColorPicker() {
        JPanel shapePickGrid = new JPanel(new GridLayout());
        shapePickGrid.setPreferredSize(new Dimension(this._frame.getSize().width, 40));
        for (Color c: this._colorOptions) { // Go through all colors and add them to panel
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

    /**
     * <h2>Create drawing board</h2>
     * <p>Creates drawing board and adds it to frame</p>
     */
    private void CreateDrawingBoard() {
        drawingPanel = new DrawingPanel();
        drawingPanel.addMouseMotionListener(this);
        drawingPanel.setPreferredSize(new Dimension(800, 500)); // Arbitrary initial size
        this._frame.add(drawingPanel);
    }

    /**
     * <h2>Create status bar</h2>
     * <p>Creates status bar and adds it to frame</h2>
     */
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

    /**
     * <h2>Reset frame</h2>
     * <p>Redraws title and DrawingPanel</p>
     */
    private void resetFrame() {
        this._frame.setTitle(this._appTitle + " - " + this.drawingPanel.getDrawing().getFullName());
        this.drawingPanel.updateUI();
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

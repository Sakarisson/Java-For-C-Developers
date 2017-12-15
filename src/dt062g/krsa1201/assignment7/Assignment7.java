package dt062g.krsa1201.assignment7;

import javax.swing.SwingUtilities;

/**
* <h1>Assignment 7</h1>
* This class is the starting point for the drawing application.
* It creates our JFrame and makes it visible.
* 
*
* @author  Kristian (krsa1201)
* @version 1.0
* @since   15-12-2017
*/
public class Assignment7 {

    public static void main(String[] args) {
        // Make sure GUI is created on the event dispatching thread
        // This will be explained in the lesson about threads
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Interface myInterface = new Interface();
            }
        });
    }
}
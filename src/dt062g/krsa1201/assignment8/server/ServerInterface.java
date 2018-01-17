package dt062g.krsa1201.assignment8.server;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <h2>Server Interface</h2>
 * <p>A simple interface for the server</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 17-01-2018
 */
public class ServerInterface {
    // Private variables
    private JFrame _frame;

    public ServerInterface() {
        _frame = new JFrame();
        JPanel background = new JPanel();
        background.setBackground(Color.black);
        _frame.add(background);
        _frame.setVisible(true);
    }
}

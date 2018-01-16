package dt062g.krsa1201.assignment8.server;

import java.net.Socket;

/**
 * <h1>ClientHandler</h1>
 * <p>Our "connection" class, which the server uses to handle individual clients</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 16-01-2018
 */
public class ClientHandler extends Thread {
    Socket _socket;

    public ClientHandler(Socket socket) {
        this._socket = socket;
    }

    @Override
    public void run() {

    }
}

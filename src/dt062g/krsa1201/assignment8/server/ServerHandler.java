package dt062g.krsa1201.assignment8.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerHandler {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        final ArrayList<Server> connections = new ArrayList<>();
        final ServerSocket server;

        try {
            server = new ServerSocket(10000);
            while (true) {
                Socket client = server.accept();
                Server connection = new Server(client);
                connections.add(connection);
                System.out.println("Connected clients: " + connections.size());
            }
        } catch (IOException e) {
            
        }
    }
}

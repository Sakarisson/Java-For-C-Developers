package dt062g.krsa1201.assignment8.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * <h1>Server</h1>
 * <p>The server class, can communicate with several drawing programs</p>
 * @author Kristian Sakarisson (krsa1201)
 * @version 1.0
 * @since 16-01-2018
 */
public class Server {
    // private data members
    private static ArrayList<Socket> connectedClients = new ArrayList<Socket>();
    
    public static void main(String[] args) throws Exception {
        System.out.println(args);
        Server server = new Server();
        server.Start();
        System.out.println("done");
    }

    public static void Start() {
        try {
            ServerSocket server = new ServerSocket(10000);
            Socket clientSocket = server.accept();
            DataInputStream dIn = new DataInputStream(clientSocket.getInputStream());

            while (dIn.available() > 0) {
                System.out.println(dIn.readLine());
            }
            PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
            printStream.println("Hello");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

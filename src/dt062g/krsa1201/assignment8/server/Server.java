package dt062g.krsa1201.assignment8.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println(args);
        Start();
        System.out.println("done");
    }

    public static void Start() {
        try {
        ServerSocket server = new ServerSocket(12321);
        Socket clientSocket = server.accept();
        DataInputStream dIn = new DataInputStream(clientSocket.getInputStream());
        while(dIn.available() > 0) {
            System.out.println(dIn.readLine());
        }
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        out.writeBytes("Hello");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

package dt062g.krsa1201.assignment8.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public Server() {
    try {
      ServerSocket server = new ServerSocket(12345);
      Socket clientSocket = server.accept();
    } catch (IOException e) {

    }
  }
}

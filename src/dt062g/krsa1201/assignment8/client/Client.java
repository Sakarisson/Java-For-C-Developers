package dt062g.krsa1201.assignment8.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends Thread implements Runnable {

    private String _address;
    private int _port;

    private Socket socket;
    private BufferedReader input;
    private BufferedWriter output;

    public static String DEFAULT_ADDRESS = "localhost";
    public static int DEFAULT_PORT = 10000;

    public Client() {
        _address = DEFAULT_ADDRESS;
        _port = DEFAULT_PORT;
        start();
    }

    public Client(String address, int port) {
        _address = address;
        _port = port;
        start();
    }

    @Override
    public void run() {
        System.out.println("Client is running");
        try {
            System.out.println("Connecting to server at " + _address + ":" + _port);
            socket = new Socket(_address, _port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void disconnect() {
        if (socket.isConnected()) {
            try {
                output.write("DISCONNECT\r");
                output.close();
                input.close();
                socket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String[] getFilenamesFromServer() {
        try {
            output.write("GETFILES\r");
            output.flush();
            int numberOfFiles = Integer.parseInt(input.readLine());
            String[] files = new String[numberOfFiles];
            int index = 0;
            while(index < numberOfFiles) {
                String file = input.readLine();
                files[index++] = file;
            }
            return files;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new String[] { "" };
    }

    public String getFile(String filename) {
        String contents = "";
        try {
            output.write("GETFILE\r");
            output.flush();
            output.write(filename + "\r");
            output.flush();
            int numberOfLines = Integer.parseInt(input.readLine());
            System.out.print(numberOfLines);
            if (numberOfLines > 0) {
                contents = input.readLine();
                for (int i = 0; i < numberOfLines; i++) {
                    contents += input.readLine() + "\n";
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contents;
    }

    public void saveFile(String filename, int numberOfLines, String fileContents) {
        try {
            output.write("SAVEFILE\r");
            output.flush();
            output.write(filename + "\r");
            output.flush();
            output.write(numberOfLines + "\r");
            output.flush();
            output.write(fileContents);
            output.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

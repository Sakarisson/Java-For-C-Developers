package dt062g.krsa1201.assignment8.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Server extends Thread implements Runnable {
    private Socket _socket;
    BufferedReader reader;
    private BufferedWriter writer;

    private enum COMMAND {
        DISCONNECT,
        GETFILES,
        GETFILE,
        SAVEFILE,
        DEFAULT
    }
    
    public Server(Socket socket) {
        System.out.println("New connection from " + socket.getInetAddress() + ":" + socket.getPort());
        _socket = socket;
        // Starts thread
        start();
    }

    /**
     * <h2>Interpret message</h2>
     * <p>Interprets message received using an enum hack (my Java version doesn't
     * support Strings in switch statements)</p>
     * <p>https://stackoverflow.com/questions/338206/why-cant-i-switch-on-a-string/338230#338230</p>
     */
    private void InterpretMessage(String message) {
        COMMAND cmd;
        try {
            cmd = COMMAND.valueOf(message);
        } catch (IllegalArgumentException e) {
            cmd = COMMAND.DEFAULT;
        }

        switch (cmd) {
            case DISCONNECT:
                closeConnection();
                break;
            case GETFILES:
                getFiles();
                break;
            case GETFILE:
                getFile();
                break;
            case SAVEFILE:
                saveFile();
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }

    private void closeConnection() {
        try {
            _socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getFiles() {
        String[] filenames = new String[0];
        try {
            File filesDir = new File("./files");
            filesDir.mkdir();
            File[] files = filesDir.listFiles();
            filenames = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                filenames[i] = files[i].getName();
            }   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            writer.write("" + filenames.length + "\r");
            writer.flush();
            for (String file : filenames) {
                writer.write(file + "\r");
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getFile() {
        String contents = "";
        try {
            String filename = reader.readLine();
            File file = new File("./files/" + filename);
            if (!file.exists()) {
                writer.write("0\r");
                writer.flush();
                return;
            }
            InputStream is = new FileInputStream(file);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line;
            int lineCounter = 0;
            while((line = buf.readLine()) != null) {
                contents += line + "\n";
                lineCounter++;
            }
            writer.write(lineCounter + "\r");
            writer.write(contents + "\r");
            writer.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeFile(String filename, String contents) {
        File file = new File("./files/" + filename);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(contents);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveFile() {
        try {
            String filename = reader.readLine();
            System.out.println(filename);
            int numberOfLines = Integer.parseInt(reader.readLine());
            System.out.println(numberOfLines);
            String fileContents = "";
            for (int i = 0; i < numberOfLines; i++) {
                fileContents += reader.readLine() + "\n";
            }
            writeFile(filename, fileContents);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream()));
            while (true) {
                String message = reader.readLine().trim();
                System.out.println("New message received: " + message);
                InterpretMessage(message);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

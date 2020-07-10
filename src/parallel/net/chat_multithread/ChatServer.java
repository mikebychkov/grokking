package parallel.net.chat_multithread;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private ArrayList<PrintWriter> clientOutputStreams;

    public class ClientHandler implements Runnable {
        private Socket so;
        private BufferedReader reader;
        private Thread t;

        public ClientHandler(Socket so) {
            try {
                this.so = so;
                reader = new BufferedReader(new InputStreamReader(so.getInputStream()));
                t = new Thread(this);
                t.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("Read " + message);
                    tellEveryone(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.go();
    }

    public void go() {
        clientOutputStreams = new ArrayList<>();
        try {
            ServerSocket ss = new ServerSocket(4242);
            while (true) {
                Socket so = ss.accept();
                PrintWriter writer = new PrintWriter(so.getOutputStream());
                clientOutputStreams.add(writer);
                new ClientHandler(so);
                System.out.println("Got a connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tellEveryone(String message) {
        for (PrintWriter writer : clientOutputStreams) {
            try {
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

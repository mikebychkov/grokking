package parallel.net.chat_multithread;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {

    private BufferedReader reader;
    private PrintWriter writer;
    private Socket so;

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.go();
    }

    public void go() {
        setUpNetworking();
        new IncomingReader();
        Scanner userIn = new Scanner(System.in);
        while (true) {
            String input = userIn.nextLine();
            Action(input);
        }
    }

    private void setUpNetworking() {
        try {
            so = new Socket("127.0.0.1", 4242);
            reader = new BufferedReader(new InputStreamReader(so.getInputStream()));
            writer = new PrintWriter(so.getOutputStream());
            System.out.println("Networking established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Action(String message) {
        try {
            writer.println(message);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class IncomingReader implements Runnable {

        private Thread t;

        public IncomingReader() {
            t = new Thread(this);
            t.start();
        }

        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("# " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package parallel.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleChatServer {

    public void go() {
        try {
            ServerSocket ss = new ServerSocket(4242);
            while (true) {
                System.out.println("Waiting for connection...");
                Socket so = ss.accept();
                System.out.println("Socket#1 accepted!");
                String msg;
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(so.getInputStream()))) {
                    msg = reader.readLine();
                    System.out.println("Message: " + msg);
                }
                Socket so2 = ss.accept();
                System.out.println("Socket#2 accepted!");
                try (PrintWriter writer = new PrintWriter(so2.getOutputStream())) {
                    System.out.println("Sending back message: " + msg);
                    writer.println(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChatServer server = new ConsoleChatServer();
        server.go();
    }

}

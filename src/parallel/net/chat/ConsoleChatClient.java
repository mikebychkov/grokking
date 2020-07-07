package parallel.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleChatClient {

    public void go() {
        Scanner userIn = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter message:");
                String msg = userIn.nextLine();
                Socket s = new Socket("127.0.0.1", 4242);
                try (PrintWriter writer = new PrintWriter(s.getOutputStream());
                     BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
                    System.out.println("Sending message...");
                    writer.println(msg);
                    writer.flush();
                    System.out.println("Reading server answer...");
                    String rsl = reader.readLine();
                    System.out.println("Server said: " + rsl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChatClient client = new ConsoleChatClient();
        client.go();
    }

}

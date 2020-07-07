package parallel.net.examples.daily_advise;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DailyAdviceServer {

    private List<String> adviceList = Arrays.asList(
            "Advice #1", "Advice #2", "Advice #3", "Advice #4", "Advice #5"
    );

    public void go() {
        try {
            ServerSocket ss = new ServerSocket(4242);
            while (true) {
                Socket so = ss.accept();
                try (PrintWriter writer = new PrintWriter(so.getOutputStream())) {
                    writer.println(getAdvice());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        Random rnd = new Random();
        return adviceList.get(rnd.nextInt(adviceList.size()));
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}

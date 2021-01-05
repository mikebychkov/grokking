import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

    private volatile String data = "Hello singleton";

    private static class Holder {
        private static final App app = new App();
    }

    public static App getInstance() {
        return Holder.app;
    }

    private App() {
        System.out.println("################ SINGLETON CONSTRUCTOR");
    }

    public String getData() {
        synchronized (this) {
            return data;
        }
    }

    public void setData(String data) {
        synchronized (this) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Program started!");
        Thread.sleep(3000);
        App theApp = App.getInstance();
        System.out.println("DATA: " + theApp.getData());
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future f = pool.submit(
                () -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("################ START SETTING NEW DATA");
                    App.getInstance().setData("NEW SINGLETON VALUE");
                    System.out.println("################ END SETTING NEW DATA");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        );
        while (!f.isDone()) {
            System.out.println(App.getInstance().getData());
        }
        pool.shutdown();
        while (!pool.isTerminated()) {
            Thread.sleep(1000);
        }
    }
}

package parallel.executor_service;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger ai = new AtomicInteger(0);
        Callable<String> task = () -> {
            Thread.currentThread().setName("MY THREAD #" + ai.addAndGet(1));
            String name = Thread.currentThread().getName();
            System.out.println(name);
            return name;
        };
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            System.out.println(">>>>>>>ITERATION #" + i);
            //Future result = service.submit(task);
            //System.out.println(result.get());
            service.submit(task);
        }
        service.shutdown();
    }
}

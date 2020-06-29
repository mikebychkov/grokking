package parallel.schildt.fork_join.sqrt_transform;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {

    public static void main(String[] args) {
        double[] data = new double[100000];

        for (int i = 0; i < data.length; i++) {
            data[i] = (double) i;
        }

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new SqrtTransform(data, 0, data.length));

        for (int i = 100; i < 110; i++) {
            System.out.println(data[i]);
        }
    }
}

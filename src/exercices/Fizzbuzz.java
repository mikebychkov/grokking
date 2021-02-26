package exercices;

import java.time.LocalDateTime;

public class Fizzbuzz {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        fizzBuzz(1000000);
        long end = System.currentTimeMillis();
        System.out.printf("\n%s", end - start);
    }

    private static void fizzBuzz(int val) {
        for (int i = 1; i <= val; i++) {
            String s = "";
            if (i % 3 == 0) {
                s += "fizz";
            }
            if (i % 5 == 0) {
                s += "buzz";
            }
            if (s.isEmpty()) {
                s += String.valueOf(i);
            }
            System.out.println(s);
        }
    }

    private static void fizzBuzz2(int val) {
        for (int i = 1; i <= val; i++) {
            if (i % 15 == 0) {
                System.out.println("fizzbuzz");
                continue;
            }
            if (i % 3 == 0) {
                System.out.println("fizz");
                continue;
            }
            if (i % 5 == 0) {
                System.out.println("buzz");
                continue;
            }
            System.out.println(i);
        }
    }
}

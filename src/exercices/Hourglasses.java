package exercices;

import java.util.*;

public class Hourglasses {

    static List<Point> idx = Arrays.asList(
            Point.of(0,0), Point.of(0,1), Point.of(0,2),
            Point.of(1,1),
            Point.of(2,0), Point.of(2,1), Point.of(2,2)
    );

    static class Point {
        public int x;
        public int y;
        public static Point of(int x, int y) {
            Point p = new Point();
            p.x = x;
            p.y = y;
            return p;
        }
    }

    public static int sum(int[][] arr, int shiftX, int shiftY) {
        int sum = 0;
        for (Point p : idx) {
            sum += arr[p.x + shiftX][p.y + shiftY];
        }
        return sum;
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                int sum = sum(arr, x, y);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5},
        };
        System.out.println(hourglassSum(arr));
    }
}

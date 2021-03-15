package exercices;

import java.util.Arrays;

public class MinimumSwap {

    static void swap(int[] arr, int idx1, int idx2) {
        int val = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = val;
    }

    static int minimumSwaps(int[] arr) {

        int rsl = 0;

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);

        while (!Arrays.equals(arr, copy)) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != copy[i]) {
                    rsl++;
                    int destIdx = Arrays.binarySearch(copy, arr[i]);
                    swap(arr, i, destIdx);
                }
            }
        }

        return rsl;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2}; // 3
        System.out.println(minimumSwaps(arr));
    }
}

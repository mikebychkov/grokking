package ch02;

public class RecursiveSum {

    public static int rSum(int[] arr, int index) {
        if (arr.length == index) return 0;
        return arr[index++] + rSum(arr, index);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2 , 3 , 4 , 5};
        System.out.println(rSum(arr, 0));
    }
}

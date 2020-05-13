package algo.ch04;

public class RecursiveSum {

    public static int rSum(int[] arr, int index) {
        if (arr.length == index) return 0;
        return arr[index++] + rSum(arr, index);
    }

    public static int rMax(int[] arr, int index) {
        if (arr.length == index) return 0;
        int nextVal = rMax(arr, index + 1);
        return arr[index] > nextVal ? arr[index] : nextVal;
    }

    public static int rSearch(int item, int[] arr, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) >> 1;
        int guess = arr[mid];
        if (guess == item) {
            return mid;
        } else if (guess < item) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
        return rSearch(item, arr, low, high);
    }
}

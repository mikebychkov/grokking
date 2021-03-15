package algo.ch01;

public class BinarySearch2 implements BS {

    @Override
    public int search(int[] list, int item) {
        return sub(list, item, 0, list.length - 1);
    }

    private int sub(int[] list, int item, int start, int end) {
        int x = (start + end) / 2;
        if (start == end) return -1;
        if (list[x] == item) return x;
        if (list[x] > item) {
            return sub(list, item, start, x);
        } else {
            return sub(list, item, x + 1, end);
        }
    }
}

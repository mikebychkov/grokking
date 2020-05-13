package algo.ch04;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class RecursiveSumTest {

    @Test
    public void rSum() {
        int[] arr = {1, 2 , 3 , 4 , 5};
        assertThat(RecursiveSum.rSum(arr, 0), is(15));
    }

    @Test
    public void rMax() {
        int[] arr = {1, 23 , 13 , 444 , 51};
        assertThat(RecursiveSum.rMax(arr, 0), is(444));
    }

    @Test
    public void search_odd_true() {
        int[] input = {1, 3, 5, 7, 9};
        int result = RecursiveSum.rSearch(3, input, 0, input.length - 1);
        assertThat(result, is(1));
    }

    @Test
    public void search_odd_false() {
        int[] input = {1, 3, 5, 7, 9};
        int result = RecursiveSum.rSearch(10, input, 0, input.length - 1);
        assertThat(result, is(-1));
    }

    @Test
    public void search_even_true() {
        int[] input = {1, 3, 5, 7, 9, 11};
        int result = RecursiveSum.rSearch(3, input, 0, input.length - 1);
        assertThat(result, is(1));
    }

    @Test
    public void search_even_false() {
        int[] input = {1, 3, 5, 7, 9, 11};
        int result = RecursiveSum.rSearch(10, input, 0, input.length - 1);
        assertThat(result, is(-1));
    }
}

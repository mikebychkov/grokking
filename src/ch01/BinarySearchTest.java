package ch01;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {
    @Test
    public void search_odd_true() {
        int[] input = {1, 3, 5, 7, 9};
        int result = BinarySearch.search(input, 3);
        assertThat(result, is(1));
    }

    @Test
    public void search_odd_false() {
        int[] input = {1, 3, 5, 7, 9};
        int result = BinarySearch.search(input, 10);
        assertThat(result, is(-1));
    }

    @Test
    public void search_even_true() {
        int[] input = {1, 3, 5, 7, 9, 11};
        int result = BinarySearch.search(input, 3);
        assertThat(result, is(1));
    }

    @Test
    public void search_even_false() {
        int[] input = {1, 3, 5, 7, 9, 11};
        int result = BinarySearch.search(input, 10);
        assertThat(result, is(-1));
    }
}

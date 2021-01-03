package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestJob {

    private final static String str = "petro Pavlovsk Amur darya Pripyat Poprigunchik Palindrom antonio Pripyat Beluchy Pavlovsk Mickelangelo";

    public static void main(String[] args) {

        List<String> words = Arrays.stream(str.split(" ")).filter(w -> w.toCharArray()[0] == 'P' && w.length() <= 9)
                        .sorted().distinct().collect(Collectors.toList());
        System.out.println(words);
    }
}

package stream_api;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMap {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 5, 3, 2, 7);
        Map<Integer, Integer> map = list.stream().collect(
                Collectors.toMap(k -> k, v -> v)
        );
        System.out.println(map);
        //
        int reducedValue = list.stream().reduce((a, b) -> a + b).get();
        System.out.println(reducedValue);
        //
        List<Integer> list2 = List.of(11, 15, 13, 12, 17);
        List<Integer> list3 = List.of(list, list2).stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(list3);
    }
}

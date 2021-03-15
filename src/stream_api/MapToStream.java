package stream_api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapToStream {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "tree");
        //
        map.entrySet().stream().forEach(System.out::println);
        //
        map.entrySet().stream().flatMap(
                (e) -> (List.of(e.getKey(), e.getValue()).stream())
        ).forEach(System.out::println);
        //
        String rsl = map.values().stream().reduce((a, b) -> (a + " " + b)).get();
        System.out.println(rsl);
    }
}

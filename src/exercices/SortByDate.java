package exercices;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SortByDate {

    static class Data {
        String name;
        String date;

        public Data(String name, String date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }

    static List<Data> sortData(Data[] data) {
        TreeMap<LocalDateTime, Data> map = new TreeMap<>();
        for (Data d : data) {
            map.put(dateFromStr(d.date), d);
        }
        List<Data> rsl = new ArrayList<>(map.values());
        return rsl;
    }

    static LocalDateTime dateFromStr(String str) {
        String dd = str.substring(0, 2);
        String mm = str.substring(2, 4);
        String yy = str.substring(4, 8);
        return LocalDateTime.of(Integer.parseInt(yy), Integer.parseInt(mm), Integer.parseInt(dd), 1, 1, 1);
    }

    public static void main(String[] args) {

        Data[] data = {
                new Data("Name1", "01012021"),
                new Data("Name2", "01032021"),
                new Data("Name3", "01022021")
        };

        System.out.println(sortData(data));

    }
}

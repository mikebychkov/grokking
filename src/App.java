import java.util.StringJoiner;

public class App {

    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(",");
        System.out.println(sj.toString());
        sj.add("Elem #1");
        System.out.println(sj.toString());
        sj.add("Elem #2");
        System.out.println(sj.toString());    }
}

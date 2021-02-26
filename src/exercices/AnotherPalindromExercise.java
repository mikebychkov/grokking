package exercices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Special String Again
 * https://www.hackerrank.com/challenges/special-palindrome-again?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */

public class AnotherPalindromExercise {

    static Map<String, Integer> mapString(String s) {
        Map<String, Integer> rsl = new HashMap<>();
        for (char c : s.toCharArray()) {
            String myStr = String.valueOf(c);
            rsl.put(myStr, rsl.getOrDefault(myStr, 0) + 1);
        }
        return rsl;
    }

    static int countPs(String s) {

        int rsl = s.length();

        for (int i = 0; i < s.length(); i++) {

            StringJoiner sb = new StringJoiner("");

            for (int j = i; j < s.length(); j++) {

                sb.add(String.valueOf(s.charAt(j)));

                int length = sb.length();

                if (length < 2) continue;

                int halfLength = length / 2;

                char[] ss = sb.toString().toCharArray();

                boolean spes = true;
                for (int x = 0; x < halfLength; x++) {
                    if (ss[x] == ss[length - 1 - x] && ss[x] == ss[0]) {
                        continue;
                    }
                    spes = false;
                }

                if (spes) rsl++;
            }
        }

        return rsl;
    }

    static int countPs2(String s) {

        int len = s.length();
        int rsl = len;

        String part = "";
        Set<Character> diff = new HashSet<>();
        Map<Character, Integer> diff2 = new HashMap<>();

        for (int i = 0; i < len; i++) {

            part = "";
            diff.clear();
            diff2.clear();

            for (int j = i; j < len; j++) {

                //System.out.printf("%s:%s\n", i, j);

                char c = s.charAt(j);

                diff.add(c);
                if (diff.size() > 2) {
                    break;
                }

                part += c;

                if (part.charAt(0) != c) {
                    diff2.put(c, diff2.getOrDefault(c, 0) + 1);
                    if (diff2.get(c) > 1) {
                        break;
                    }
                    continue;
                }

                if (part.length() < 2) continue;

                if (isSpec(part)) {
                    //System.out.println(part);
                    rsl++;
                }
            }
        }

        return rsl;
    }

    private static boolean isSpec(String part) {

        int length = part.length();

        int halfLength = length / 2;

        char[] ss = part.toCharArray();

        for (int x = 0; x < halfLength; x++) {
            if (ss[x] == ss[length - 1 - x] && ss[x] == ss[0]) {
                continue;
            }
            return false;
        }
        return true;
    }

    private static boolean isSpec2(String part) {

        int halfLength = part.length() / 2;

        String hs = part.substring(0, halfLength);
        String sh = new StringBuilder(hs).reverse().toString();

        return part.endsWith(sh);
    }

    public static void main(String[] args) throws Exception {

        String s = "abcbaba";

        ///*
        try (BufferedReader read = new BufferedReader(new FileReader("input2.txt"))) {
            s = read.readLine();
        }
        // */

        System.out.println(countPs2(s));

    }
}

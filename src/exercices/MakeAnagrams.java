package exercices;

import java.util.HashMap;
import java.util.Map;

public class MakeAnagrams {

    static Map<Character, Integer> badChars(String str, String lookup) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (lookup.indexOf(c) == -1) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        //
        String newWord = deleteBadChars(str, map);
        System.out.printf("%s : %s : %s (%s)\n", map, countBadChars(map), newWord, newWord.length());
        //
        return map;
    }

    static int countBadChars(Map<Character, Integer> chars) {
        int rsl = 0;
        for (int i : chars.values()) {
            rsl += i;
        }
        return rsl;
    }

    static String deleteBadChars(String str, Map<Character, Integer> chars) {
        for (char c : chars.keySet()) {
            str = str.replaceAll(String.valueOf(c), "");
        }
        return str;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    static Map<Character, Integer> allChars(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    static int makeAnagram(String a, String b) {
        Map<Character, Integer> cA = allChars(a);
        Map<Character, Integer> cB = allChars(b);
        int rsl = 0;
        for (Map.Entry<Character, Integer> en : cA.entrySet()) {
            int countB = cB.getOrDefault(en.getKey(), -1);
            if (countB == -1) continue;
            rsl += Math.min(countB, en.getValue())*2;
        }
        return a.length() + b.length() - rsl;
    }

    public static void main(String[] args) {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(makeAnagram(a, b));
    }
}

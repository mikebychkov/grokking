package exercices;

import java.util.*;

public class Substrings {

    public static String isIt(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        for (int i = 0; i < a1.length; i++) {
            if (s2.contains(String.valueOf(a1[i]))) {
                return "YES";
            }
        }
        return "NO";
    }

    public static String isIt2(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < a1.length; i++) {
            set1.add(a1[i]);
        }
        for (int i = 0; i < a2.length; i++) {
            set2.add(a2[i]);
        }
        for (char c : set1) {
            if (set2.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void chars() {

        char[] ar = "aAzZ".toCharArray();

        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%s : %s\n", i, Character.codePointAt(ar, i));
        }

        char c = Character.toChars(97)[0];
        System.out.println(c);

        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toUpperCase(122));

    }

    public static int anagrams(String s) {

        char[] ar = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(ar[j]);
                String key = strSort(sb.toString());
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        //System.out.println(map);
        return map.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> pairs(e.getValue())).reduce((a,b) -> a + b).orElse(0);
    }

    public static String strSort(String s) {
        char[] c =  s.toCharArray();
        Arrays.sort(c);
        return Arrays.toString(c);
    }

    public static int pairs(int i) {
        if (i < 3) {
            return i - 1;
        }
        return i - 1 + pairs(i - 1);
    }

    public static void main(String[] args) {

        //chars();

        //System.out.println(isIt2("abc", "bca"));

        ///*
        System.out.println(anagrams("ifailuhkqq")); // 3
        System.out.println(anagrams("kkkk")); // 10
        //*/

        ///*
        System.out.println(anagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel")); // 399
        System.out.println(anagrams("gffryqktmwocejbxfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfcogzatyskqjyorcftwxjrtgayvllutrjxpbzggjxbmxpnde")); // 471
        System.out.println(anagrams("mqmtjwxaaaxklheghvqcyhaaegtlyntxmoluqlzvuzgkwhkkfpwarkckansgabfclzgnumdrojexnrdunivxqjzfbzsodycnsnmw")); // 370
        System.out.println(anagrams("ofeqjnqnxwidhbuxxhfwargwkikjqwyghpsygjxyrarcoacwnhxyqlrviikfuiuotifznqmzpjrxycnqktkryutpqvbgbgthfges")); // 403
        System.out.println(anagrams("zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw")); // 428
        //*/

        ///*
        System.out.println(anagrams("dbcfibibcheigfccacfegicigcefieeeeegcghggdheichgafhdigffgifidfbeaccadabecbdcgieaffbigffcecahafcafhcdg")); // 1464
        System.out.println(anagrams("dfcaabeaeeabfffcdbbfaffadcacdeeabcadabfdefcfcbbacadaeafcfceeedacbafdebbffcecdbfebdbfdbdecbfbadddbcec")); // 2452
        System.out.println(anagrams("gjjkaaakklheghidclhaaeggllagkmblhdlmihmgkjhkkfcjaekckaafgabfclmgahmdebjekaedhaiikdjmfbmfbdlcafamjbfe")); // 873
        System.out.println(anagrams("fdbdidhaiqbggqkhdmqhmemgljaphocpaacdohnokfqmlpmiioedpnjhphmjjnjlpihmpodgkmookedkehfaceklbljcjglncfal")); // 585
        System.out.println(anagrams("bcgdehhbcefeeadchgaheddegbiihehcbbdffiiiifgibhfbchffcaiabbbcceabehhiffggghbafabbaaebgediafabafdicdhg")); // 1305
        System.out.println(anagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); // 166650
        System.out.println(anagrams("mhmgmbbccbbaffhbncgndbffkjbhmkfncmihhdhcebmchnfacdigflhhbekhfejblegakjjiejeenibemfmkfjbkkmlichlkbnhc")); // 840
        System.out.println(anagrams("fdacbaeacbdbaaacafdfbbdcefadgfcagdfcgbgeafbfbggdedfbdefdbgbefcgdababafgffedbefdecbaabdaafggceffbacgb")); // 2134
        System.out.println(anagrams("bahdcafcdadbdgagdddcidaaicggcfdbfeeeghiibbdhabdhffddhffcdccfdddhgiceciffhgdibfdacbidgagdadhdceibbbcc")); // 1571
        System.out.println(anagrams("dichcagakdajjhhdhegiifiiggjebejejciaabbifkcbdeigajhgfcfdgekfajbcdifikafkgjjjfefkdbeicgiccgkjheeiefje")); // 1042
        //*/
    }
}

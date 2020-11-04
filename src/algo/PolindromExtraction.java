package algo;

import java.util.*;

class PolindromExtraction {

    public static class Polindrom implements Comparable<Polindrom> {

        public String word;
        public int index1;
        public int index2;

        public static Polindrom of(String word, int index1, int index2) {
            Polindrom pol = new Polindrom();
            pol.word = word;
            pol.index1 = index1;
            pol.index2 = index2;
            return pol;
        }

        public int length() {
            return word.length();
        }

        @Override
        public int compareTo(Polindrom pol) {
            if(this.word.length() > pol.word.length()) {
                return -1;
            } else if(this.word.length() < pol.word.length()) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return word + " (" + index1 + "," + index2 + ":" + length() + ")";
        }
    }

    public static String getPolindromWord(char[] arr) {
        Arrays.sort(arr);

        Map<Character, Integer> map = new HashMap<>();

        for(char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Character theVeryOddChar = Character.valueOf(' ');
        int theVeryOddValue = 0;

        LinkedList<Character> midPart = new LinkedList<>();
        LinkedList<Character> leftPart = new LinkedList<>();
        LinkedList<Character> rightPart = new LinkedList<>();

        for(Map.Entry<Character, Integer> en : map.entrySet()) {
            char k = en.getKey();
            int v = en.getValue();
            if(v % 2 == 1) {
                if(v > theVeryOddValue) {
                    theVeryOddValue = v;
                    theVeryOddChar = k;
                }
            };
        }

        for(Map.Entry<Character, Integer> en : map.entrySet()) {
            char k = en.getKey();
            int v = en.getValue();

            if(theVeryOddChar == k) continue;

            int v2 = v % 2 == 1 ? v - 1 : v;
            v2 = v2 / 2;
            for(int i = 0; i < v2; i++) {
                leftPart.add(k);
                rightPart.push(k);
            }
        }

        for(int i = 0; i < theVeryOddValue; i++) {
            midPart.add(theVeryOddChar);
        }

        String rsl = listToString(leftPart)
                + listToString(midPart)
                + listToString(rightPart);

        return rsl;
    }

    public static String getSequencePolindromWord(char[] arr) {

        String arrStr = new String(arr);

        String maxPoli = "";

        for(int i = 0; i < arr.length; i++) {
            List<Character> tmp = new LinkedList<>();
            for(int j = i; j < arr.length; j++) {
                tmp.add(arr[j]);
                if(tmp.size() == 1) continue;
                char[] backwards = new char[tmp.size()];
                for (int k = 0; k < tmp.size(); k++) {
                    backwards[k] = tmp.get(tmp.size() - 1 - k);
                }
                String backwardsStr = new String(backwards);
                if(arrStr.contains(backwardsStr)) {
                    if(backwardsStr.length() > maxPoli.length()) {
                        maxPoli = backwardsStr;
                    }
                }
            }
        }

        return maxPoli;
    }

    public static String listToString(List<Character> list) {
        char[] arr = new char[list.size()];
        for(int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return new String(arr);
    }

    public static char[] listToArr(List<Character> list) {
        char[] arr = new char[list.size()];
        for(int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }

    public static int processSequence(String seq) {

        List<Polindrom> pols1 = new ArrayList<>();
        List<Polindrom> pols2 = new ArrayList<>();

        List<Character> list = new ArrayList<>();

        for(int i = 0; i < seq.length(); i++) {
            list.add(seq.charAt(i));
            //String poli = getPolindromWord(listToArr(list));
            String poli = getSequencePolindromWord(listToArr(list));
            if(poli.length() == 1) continue;
            pols1.add(Polindrom.of(poli, 0, i));
        }

        list.clear();

        for(int i = seq.length() - 1; i >= 0; i--) {
            list.add(seq.charAt(i));
            //String poli = getPolindromWord(listToArr(list));
            String poli = getSequencePolindromWord(listToArr(list));
            if(poli.length() == 1) continue;
            pols2.add(Polindrom.of(poli, i, seq.length() - 1));
        }

        int maxProduct = 0;
        Polindrom maxPoli1 = null;
        Polindrom maxPoli2 = null;

        for(Polindrom poli1 : pols1) {
            for(Polindrom poli2 : pols2) {
                if(poli1.index2 < poli2.index1) {
                    int rsl = poli1.length() * poli2.length();
                    if(rsl > maxProduct) {
                        maxProduct = rsl;
                        maxPoli1 = poli1;
                        maxPoli2 = poli2;
                    }
                }
            }
        }

        System.out.println("\n\n");
        System.out.println(maxPoli1);
        System.out.println(maxPoli2);

        return maxProduct;
    }

    public static void main(String[] args) {

        String str = "eeegeeksforskeeggeeks";

        int rsl = processSequence(str);
        System.out.println(rsl);

        //System.out.println(getSequencePolindromWord(str.toCharArray()));
    }
}

package exercices;

import java.util.StringJoiner;

public class Palindrom {

    public static boolean isPalindrom(String str) {

        String rev = new StringBuilder(str).reverse().toString();

        return str.equals(rev);
    }

    public static void main(String[] args) {

        // CASE 1

        String str = "abccba";
        System.out.println(str + " is palindrom: " + isPalindrom(str));

        // CASE 2

        String str1 = "abc1cba";
        System.out.println(str1 + " is palindrom: " + isPalindrom(str1));

        // CASE 3

        String str2 = "abc23cba";
        System.out.println(str2 + " is palindrom: " + isPalindrom(str2));
    }
}

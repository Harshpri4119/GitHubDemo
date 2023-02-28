package JavaPrac;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        String r = revereString("Harsha Vardhan");
        System.out.println(r);
    }

    public static String revereString(String s) {
        char[] letters = new char[s.length()];

        int letterIndex = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            letters[letterIndex] = s.charAt(i);
            letterIndex++;
        }

        String rev = "";
        for (int i = 0; i < s.length(); i++) {
            rev = rev + letters[i];
        }

        return rev;

    }
}

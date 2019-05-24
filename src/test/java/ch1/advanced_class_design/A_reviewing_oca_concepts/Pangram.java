package ch1.advanced_class_design.A_reviewing_oca_concepts;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pangram {
    public static final int ALPHABET_COUNT = 26;

    @Test
    public void test() {
        String input = "Two driven jocks help fax my big quiz";
        System.out.print(Pangram.isPangram(input) ? "is pangram" : "no es pangram");
    }


    public static boolean isPangram(String input) {
        if (input == null) {
            return false;
        }
        Boolean[] alphabet = new Boolean[ALPHABET_COUNT];
        Arrays.fill(alphabet, false);
        int index = 0;
        input = input.toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z') {
                index = input.charAt(i) - 'A';
                alphabet[index] = true;
            }
        }

        for (Boolean bool : alphabet) {
            if (!bool) {
                return false;
            }
        }
        return true;

    }

//    public static boolean isPangram(String str) {
//        if (str == null) {
//            return false;
//        }
//        Boolean[] alphabetMarker = new Boolean[ALPHABET_COUNT];
//        Arrays.fill(alphabetMarker, false);
//        int alphabetIndex = 0;
//        str = str.toUpperCase();
//        for (int i = 0; i < str.length(); i++) {
//            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
//                alphabetIndex = str.charAt(i) - 'A';
//                alphabetMarker[alphabetIndex] = true;
//            }
//        }
//        for (boolean index : alphabetMarker) {
//            if (!index) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isPangramWithStreams(String str) {
        if (str == null) {
            return false;
        }
        String strUpper = str.toUpperCase();

        Stream<Character> filteredCharStream = strUpper.chars()
                .filter(item -> ((item >= 'A' && item <= 'Z')))
                .mapToObj(c -> (char) c);

        Map<Character, Boolean> alphabetMap =
                filteredCharStream.collect(Collectors.toMap(item -> item, k -> Boolean.TRUE, (p1, p2) -> p1));

        return alphabetMap.size() == ALPHABET_COUNT;
    }

    class Super {
    }

    class Sub extends Super {
    }

    @Test
    public void test2() {
        int count = 0, sum = 0;
        do {
            if (count % 3 == 0) continue;
            sum += count;
        }
        while (count++ < 11);
        System.out.println(sum);
    }
}

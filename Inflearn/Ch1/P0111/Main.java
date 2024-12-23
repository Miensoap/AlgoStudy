package Inflearn.Ch1.P0111;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String[] array = splitConsequence(input);
        String compressed = Arrays.stream(array)
                .reduce("", (acc, s) -> s.length() == 1 ? acc + s.charAt(0) : acc + s.charAt(0) + s.length());

        System.out.println(compressed);
    }

    private static String[] splitConsequence(String string) {
        return Stream.of(string.split(""))
                .reduce("", (acc, c) -> acc.isEmpty() || acc.endsWith(c) ? acc + c : acc + "," + c)
                .split(",");
    }
}

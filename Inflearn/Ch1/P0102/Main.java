package Inflearn.Ch1.P0102;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inputString = in.nextLine();
        char[] chars = inputString.toCharArray();

        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (Character.isUpperCase(c)) result.append(Character.toLowerCase(c));
            else result.append(Character.toUpperCase(c));
        }

        System.out.println(result);
    }
}

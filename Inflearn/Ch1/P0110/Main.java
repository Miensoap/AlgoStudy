package Inflearn.Ch1.P0110;

import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");
        String string = input[0];
        char t = input[1].charAt(0);

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < string.length(); i++) {
            sj.add(String.valueOf(getNearestIndexOf(string, t, i)));
        }
        System.out.println(sj);
    }

    private static int getNearestIndexOf(String string, char target, int from) {
        int index = Integer.MAX_VALUE;
        for (int i = from; i < string.length(); i++) {
            if (string.charAt(i) != target) continue;

            index = i - from;
            break;
        }

        for (int i = from; i >= 0; i--) {
            if (string.charAt(i) != target) continue;

            index = Math.min(index, from - i);
        }

        return index;
    }
}

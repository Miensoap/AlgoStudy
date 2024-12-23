package Inflearn.Ch1.P0105;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();

        char[] result = string.toCharArray();

        int lt = 0, rt = string.length() - 1;
        while (lt < rt) {
            char left = string.charAt(lt);
            char right = string.charAt(rt);

            if (!Character.isAlphabetic(right)) {
                rt--;
                continue;
            }

            if (!Character.isAlphabetic(left)) {
                lt++;
                continue;
            }

            result[rt] = left;
            result[lt] = right;
            lt++;
            rt--;
        }

        System.out.println(String.valueOf(result));
    }
}

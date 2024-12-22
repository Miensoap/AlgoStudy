package Inflearn.P0109;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();

        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) sb.append(c);
        }

        System.out.println(Integer.parseInt(sb.toString()));
    }
}

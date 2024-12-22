package Inflearn.P0106;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();

        StringBuilder result = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (result.toString().contains(String.valueOf(c))) continue;
            result.append(c);
        }

        System.out.println(result);
    }
}

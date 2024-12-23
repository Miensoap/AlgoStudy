package Inflearn.Ch1.P0103;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(" ");

        String result = strings[0];
        for (String string : strings) {
            if (result.length() < string.length()) result = string;
        }

        System.out.println(result);
    }
}

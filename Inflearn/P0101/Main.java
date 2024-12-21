package Inflearn.P0101;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inputString = in.nextLine().toUpperCase();
        char character = in.nextLine().toUpperCase().charAt(0);

        long result = inputString.chars().filter(c -> c == character).count();
        System.out.println(result);
    }
}

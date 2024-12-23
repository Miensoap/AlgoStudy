package Inflearn.Ch1.P0108;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine().replaceAll("[^A-z]", "").toUpperCase();

        String reversed = new StringBuilder(string).reverse().toString();

        boolean isPalindrome = string.equals(reversed);
        System.out.println(isPalindrome ? "YES" : "NO");
    }
}

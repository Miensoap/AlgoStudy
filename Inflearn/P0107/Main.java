package Inflearn.P0107;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String reversed = new StringBuilder(string.toUpperCase()).reverse().toString();

        boolean isPalindrome = string.toUpperCase().equals(reversed);
        System.out.println(isPalindrome ? "YES" : "NO");
    }
}

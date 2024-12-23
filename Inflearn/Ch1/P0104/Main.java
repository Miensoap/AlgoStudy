package Inflearn.Ch1.P0104;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number = in.nextInt();
        in.nextLine();
        String[] strings = new String[number];

        for (int i = 0; i < number; i++) {
            strings[i] = in.nextLine();
        }

        for (String string : strings) {
            System.out.println(new StringBuilder(string).reverse());
//            System.out.println(flip(string));
        }
    }

//    private static String flip(String string) {
//        Stack<Character> stack = new Stack<>();
//
//        for (char c : string.toCharArray()) {
//            stack.push(c);
//        }
//
//        StringBuilder result = new StringBuilder();
//        while (!stack.empty()) {
//            result.append(stack.pop());
//        }
//
//        return result.toString();
//    }
}

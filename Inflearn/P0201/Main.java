package Inflearn.P0201;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        int[] numbers = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        StringJoiner result = new StringJoiner(" ");
        result.add(String.valueOf(numbers[0]));
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) result.add(String.valueOf(numbers[i]));
        }

        System.out.println(result);
    }
}

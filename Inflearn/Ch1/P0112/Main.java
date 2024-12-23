package Inflearn.Ch1.P0112;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.nextLine();
        String password = in.nextLine();

        // 암호 변환
        password = password
                .replaceAll("#", "1")
                .replaceAll("\\*", "0");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number * 7; i += 7) {
            String character = password.substring(i, i + 7);

            int ascii = Integer.parseInt(character, 2);
            sb.append((char) ascii);
        }

        System.out.println(sb);
    }
}

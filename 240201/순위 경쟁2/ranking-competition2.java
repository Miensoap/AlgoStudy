import java.util.Scanner;

public class Main {
    static String glory = "01";
    static int[] score = {0,0};
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            setScore(sc.nextLine().split(" "));
            setGlory();
        }
        System.out.println(cnt);
    }

    static void setScore(String[] in) {
        if (in[0].equals("A")) score[0] = score[0] + Integer.parseInt(in[1]);
        else score[1] = score[1] + Integer.parseInt(in[1]);
    }

    static void setGlory() {
        StringBuilder sb = new StringBuilder();
        int maxScore = 0;
        for (int j : score) {
            maxScore = Math.max(j, maxScore);
        }
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) sb.append(i);
        }

        if (!glory.equals(sb.toString())) {
            glory = sb.toString();
            cnt++;
        }
    }


}
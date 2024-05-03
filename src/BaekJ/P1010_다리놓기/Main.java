package BaekJ.P1010_다리놓기;

import java.util.*;

public class Main {

    static int[][] dp = new int[31][31];

    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        int t = sc.nextInt();

        combination();
        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(dp[n][r] );
        }
    }

    static void combination() {
        for (int i = 1; i <= 30; i++) {
            dp[i][1] = i;
        }

        //nCr = n-1Cr-1 + n-1Cr의 속성을 이용
        for (int j = 2; j <= 30; j++) {
            for (int k = 2; k <= 30; k++) {
                dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
            }
        }
    }
}

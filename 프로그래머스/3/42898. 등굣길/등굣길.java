class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

        for (int[] water : puddles) {
            dp[water[1]][water[0]] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                int up = dp[i - 1][j];
                int left = dp[i][j - 1];
                       
                // 방문 가능한 칸 최단경로 개수 더함
                dp[i][j] += up;
                dp[i][j] %= 1_000_000_007;
                dp[i][j] += left;
                dp[i][j] %= 1_000_000_007;
            }
        }

        return dp[n][m];
    }
}

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        
        // DP ? 다익스트라?
        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 왼쪽 끝
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == i) {
                    // 오른쪽 끝
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    // 둘중 큰 값 선택
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        // 마지막 줄 중 최댓값
        int max = 0;
        for (int num : triangle[height - 1]) {
            max = Math.max(max, num);
        }

        return max;
    }
}

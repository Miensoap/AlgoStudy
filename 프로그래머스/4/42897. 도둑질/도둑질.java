class Solution {
    public int solution(int[] money) {
        int[] dpO = new int[money.length]; //첫 집O
        int[] dpX = new int[money.length]; //첫 집X
        
        int len = money.length;

        // 첫집을 터는경우
        dpO[0] = money[0];
        dpO[1] = money[0];

        // 첫집을 안터는 경우
        dpX[0] = 0;
        dpX[1] = money[1];
        
        for (int i = 2; i < len; i++) {
            // i번째 턴다 vs 안턴다.
            // i번째를 털려면 i - 1은 못턴다 -> i - 2까지의 최대를 구한다.
            // ex) dpO[2] = dp0[1] vs money[2] + dpO[0]
            // dpO[3] = dpO[2] vs money[3] + dpO[1]
            dpO[i] = Math.max(dpO[i - 1], money[i] + dpO[i - 2]);
            dpX[i] = Math.max(dpX[i - 1], money[i] + dpX[i - 2]);
        }
    
        // 첫집 턴경우는 마지막집까지를 제외
        return Math.max(dpO[len - 2], dpX[len - 1]);
    }
}
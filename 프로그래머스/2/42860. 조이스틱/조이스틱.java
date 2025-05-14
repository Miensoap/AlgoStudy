class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        // 상하 이동
        for (char c : name.toCharArray()) {
            int upDown = c - 'A';
            answer += Math.min(upDown, 26 - upDown); // 반대로
        }

        // 좌우 이동
        int minMove = n - 1;
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            
            // 앞으로계속가기
            while (next < n && name.charAt(next) == 'A') next++;
            
            // 되돌아가기
            int move = i + n - next + Math.min(i, n - next); 
            
            minMove = Math.min(minMove, move);
        }

        answer += minMove;
        return answer;
    }
}

class Solution {
    boolean [] visited;
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return max;
    }
    
    void dfs(int k, int[][] dungeons, int depth) {     
        max = Math.max(max, depth); // 현재까지 탐험한 던전 수
        
        for(int i = 0; i < dungeons.length; i++) {
            int[] cur = dungeons[i];
            
            if(!visited[i] && k >= cur[0]) {
                visited[i] = true;
                dfs(k-cur[1], dungeons, depth + 1);
                visited[i] = false;
            }
        }
    }
}
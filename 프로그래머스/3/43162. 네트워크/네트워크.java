class Solution {
    int count = 0;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int c = 0; c < n; c++) {
            if(visited[c]) continue;
            count ++;
            dfs(c, computers);
        }
        
        return count;
    }
    
    void dfs(int c, int[][] computers) {
        visited[c] = true;
        int[] network = computers[c];
        
        for(int i = 0; i < network.length; i++) {
            if(network[i] == 1 && !visited[i]) dfs(i, computers);
        }
    }
}
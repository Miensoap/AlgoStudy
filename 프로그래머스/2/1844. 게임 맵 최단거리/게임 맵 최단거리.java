import java.util.*;

class Solution {
    int[][] maps;
    int[][] dist; // 각 좌표까지의 최단거리
    
    public int solution(int[][] maps) {
        this.maps = maps;
        dist = new int[maps.length][maps[0].length];
        return bfs();
    }
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    // BFS -> Queue
    int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            // 종료 : 반대쪽 끝에 도착
            if(x == maps[0].length - 1 && y == maps.length - 1) return dist[y][x];
            
            for(int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                if(canVisit(nextX, nextY)) {
                    dist[nextY][nextX] = dist[y][x] + 1; // 최단거리 방문
                    q.add(new int[]{nextX, nextY}); // 그 위치에서부터 이동 시작
                }
            }
        }
        return -1;
    }
    
    boolean canVisit(int x, int y) {
        boolean inRange = 0 <= x && x < maps[0].length && 0 <= y && y < maps.length;
        return inRange && maps[y][x] != 0 && dist[y][x] == 0; // 최초 방문만 처리
    }
}
import java.util.*;

class Solution {    
    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> holes = findArea(game_board, 0);
        List<List<int[]>> blocks = findArea(table, 1);
        
        for(int i = 0; i < holes.size(); i++) {
            holes.set(i, normalize(holes.get(i)));
        }
        
        int answer = 0;
        boolean[] used = new boolean[blocks.size()];
        for (List<int[]> hole : holes) {
            if (match(hole, blocks, used)) {
                answer += hole.size();
            }
        }
        
        return answer;
    }
    

    // 1. 모든 구멍과 블럭을 찾는다. (BFS)
    List<List<int[]>> findArea(int[][] map, int target) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        
        List<List<int[]>> areas = new ArrayList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[0].length; x++) {
                if(map[y][x] != target || visited[y][x]) continue;
                
                List<int[]> area = new ArrayList<>();
                Queue<int[]> q = new LinkedList<>();
                visited[y][x] = true;
                q.add(new int[]{x,y});
                area.add(new int[]{x,y});
                
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cx = cur[0], cy = cur[1];
                    
                    for(int d = 0; d < 4; d++) {
                        int nx = cx + dx[d];
                        int ny = cy + dy[d];
                        
                        boolean inRange = 0 <= nx && nx < map[0].length && 0 <= ny && ny < map.length;
                        
                        if(inRange && !visited[ny][nx] && map[ny][nx] == target) {
                            visited[ny][nx] = true;
                            q.add(new int[] {nx, ny});
                            area.add(new int[] {nx, ny});
                        }
                        
                    }
                }
                areas.add(area);
            }
        }     
        return areas;
    }
    
    // 2. 위치와 상관 없이 '모양' 으로 만든다
    List<int[]> normalize(List<int[]> area) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] p : area) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        List<int[]> result = new ArrayList<>();
        for (int[] p : area) {
            result.add(new int[]{p[0] - minX, p[1] - minY});
        }
        result.sort(Comparator.comparingInt((int[] p) -> p[0]).thenComparingInt(p -> p[1]));
        return result;
    }
    
    // 3. 블럭을 회전하며 일치하지 확인
    boolean match(List<int[]> hole, List<List<int[]>> blocks, boolean[] used) {
        for (int i = 0; i < blocks.size(); i++) {
            if (used[i]) continue;

            List<int[]> block = blocks.get(i);
            for (int r = 0; r < 4; r++) {
                block = rotate(block);
                if (equals(hole, block)) {
                    used[i] = true;
                    return true;
                }
            }
        }
        return false;
    }
    
    List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : shape) {
            rotated.add(new int[]{p[1], -p[0]}); // 90도 회전
        }
        return normalize(rotated);
    }
    
    boolean equals(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
}
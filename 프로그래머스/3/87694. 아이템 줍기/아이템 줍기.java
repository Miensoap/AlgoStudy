import java.util.*;

class Solution {
    int[][] map;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101]; // 2배

        // 1. 전체 -1로 초기화
        for (int[] row : map) Arrays.fill(row, -1);

        // 2. 테두리 먼저 0로 표시
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int x = x1; x <= x2; x++) {
                map[y1][x] = 0;
                map[y2][x] = 0;
            }
            for (int y = y1; y <= y2; y++) {
                map[y][x1] = 0;
                map[y][x2] = 0;
            }
        }

        // 3. 내부를 -1으로 비워서 테두리만 남기기
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[y][x] = -1;
                }
            }
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    int bfs(int cx, int cy, int ix, int iy) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cx, cy});
        map[cy][cx] = 1; // 시작 지점 거리 1로 설정

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int curDist = map[y][x];

            if (x == ix && y == iy) return curDist - 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canVisit(nx, ny)) {
                    map[ny][nx] = curDist + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }

    boolean canVisit(int x, int y) {
        boolean inRange = 0 <= x && x < map[0].length && 0 <= y && y < map.length;
        // boolean notBlocked = inRange && map[y][x] != -1;
        boolean notVisited = inRange && map[y][x] == 0;
        return notVisited;
    }
}

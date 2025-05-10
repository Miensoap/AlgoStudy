class Solution {
    public int solution(int n, int[][] wires) {
        int minDif = n;
        
        // 삭제할 간선을 완전탐색
        for (int remove = 0; remove < wires.length; remove++) {
            int[][] curWires = new int[wires.length - 1][2];
            for (int j = 0, ci = 0; j < wires.length; j++) {
                if (j == remove) continue;
                curWires[ci++] = wires[j];
            }

            minDif = Math.min(minDif, calcDif(n, curWires));
        }

        return minDif;
    }

    int calcDif(int n, int[][] wires) {
        boolean[] visited = new boolean[n];
        dfs(1, wires, visited); // 첫 번째 노드에 연결된 모든 노드 방문

        int count = 0;
        for (boolean v : visited) if (v) count++;

        return Math.abs((n - count) - count);
    }

    void dfs(int node, int[][] wires, boolean[] visited) {
        visited[node - 1] = true;

        for (int[] wire : wires) {
            int next = -1;

            if (wire[0] == node && !visited[wire[1] - 1]) {
                next = wire[1];
            } else if (wire[1] == node && !visited[wire[0] - 1]) {
                next = wire[0];
            }

            if (next != -1) {
                dfs(next, wires, visited);
            }
        }
    }
}

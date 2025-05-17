import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // vs 이차원 배열
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] cost : costs) {
            int from = cost[0], to = cost[1], weight = cost[2];
            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }

        // Prim : 가장 가까운 노드 선택하며 확장
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // 0번 정점에서 시작
        pq.offer(new int[]{0, 0}); // {노드, 비용}

        int totalCost = 0;
        
        // 간선 하나씩만 선택, 모드 연결 보장. -> 큐가 빌때까지 진행
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], cost = current[1];

            if (visited[node]) continue;

            visited[node] = true;
            totalCost += cost;

            for (int[] next : graph.get(node)) {
                if (!visited[next[0]]) {
                    pq.offer(next);
                }
            }
        }

        return totalCost;
    }
}

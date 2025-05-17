import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // Kruskal : 간선을 비용 기준으로 정렬 후, 사이클 없이 연결
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        // index 번 노드가 parent[index] 집합에 속함
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i; // 초기에는 집합 하나씩

        int totalCost = 0;
        int edgeCount = 0;

        // 비용이 작은 경로부터 사용
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int c = cost[2];
            
            // 다른 집합에 속한다 : 이어지지 않음 -> union
            if (find(parent, from) != find(parent, to)) {
                union(parent, from, to);
                
                totalCost += c;
                edgeCount++;
                
                if (edgeCount == n - 1) break; // MST 완성
            }
        }

        return totalCost;
    }

    // 해당 노드가 속한 집합 
    private int find(int[] parent, int node) {
        if (parent[node] != node) { // 자기자신이 부모가 아니면
            // path compression : 중간 경로 없이 root로 표시
            parent[node] = find(parent, parent[node]); 
        }
        
        return parent[node];
    }
    
    // 두 노드의 집합을 하나로 합침 (더 작은쪽으로)
    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        
        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
}

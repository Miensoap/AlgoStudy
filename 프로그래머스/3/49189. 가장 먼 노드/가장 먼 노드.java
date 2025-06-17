import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            int from = e[0] - 1;
            int to = e[1] - 1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        distance[0] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph.get(curr)) {
                if (distance[next] == -1) {
                    distance[next] = distance[curr] + 1;
                    q.add(next);
                }
            }
        }

        int max = Arrays.stream(distance).max().getAsInt();
        return (int) Arrays.stream(distance).filter(d -> d == max).count();
    }
}

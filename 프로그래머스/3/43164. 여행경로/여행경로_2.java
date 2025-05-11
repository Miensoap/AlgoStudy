import java.util.*;

class Solution {
    String[][] tickets;
    boolean[] used;
    List<List<String>> allRoutes = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.used = new boolean[tickets.length];

        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", path, 0);

        // 모든 경로 찾은 후 정렬
        allRoutes.sort((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return allRoutes.get(0).toArray(new String[0]);
    }

    void dfs(String current, List<String> path, int move) {
        if (move == tickets.length) {
            allRoutes.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (canVisit(i, current)) {
                used[i] = true;
                path.add(tickets[i][1]);
                
                dfs(tickets[i][1], path, move + 1);
                
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    boolean canVisit(int i, String current) {
        return !used[i] && tickets[i][0].equals(current);
    }
}

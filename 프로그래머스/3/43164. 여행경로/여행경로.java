import java.util.*;

class Solution {
    String[][] tickets;
    boolean[] used;
    List<String> answer = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        this.tickets = tickets;
        this.used = new boolean[tickets.length];

        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", path, 0);

        return answer.toArray(new String[0]);
    }

    boolean dfs(String current, List<String> path, int move) {
        if (move == tickets.length) {
            answer = new ArrayList<>(path);
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (canUse(i, current)) {
                used[i] = true;
                path.add(tickets[i][1]);

                if (dfs(tickets[i][1], path, move + 1)) return true; // 첫 번째 경로 찾았으면 즉시 종료

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    boolean canUse(int i, String current) {
        return !used[i] && tickets[i][0].equals(current);
    }
}

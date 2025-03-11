import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = this.toMap(participant);
        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1) // 차이는 1
                .findAny()
                .get().getKey();
    }

    private Map<String, Integer> toMap(String[] array) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        return map;
    }
}
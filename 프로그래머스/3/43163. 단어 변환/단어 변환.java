import java.util.*;

// 개선ver
class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        Queue<String> q = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();
        
        q.add(begin);
        dist.put(begin, 0);

        int depth = 0;
        while (!q.isEmpty()) {
            String cur = q.poll();
            int curDist = dist.get(cur);
            
            if (cur.equals(target)) return curDist;

            // 변경 가능한 알파벳 순회 대신 words 중 한글자만 다른것들 확인
            for (String word : words) { 
                if (!dist.containsKey(word) && isOneCharDiff(cur, word)) {
                    dist.put(word, curDist + 1);
                    q.add(word);
                }
            }
        }

        return 0;
    }

    boolean isOneCharDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}

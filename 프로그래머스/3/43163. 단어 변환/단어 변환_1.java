import java.util.*;

// 최초ver
class Solution {
    
    String[] words;
    int[] dist;
    Set<Character> alphas = new HashSet<>();
    
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        dist = new int[words.length];
        
        for(String word : words) {
            for(char c : word.toCharArray()) {
                alphas.add(c);
            }
        }
        
        if(indexOf(target) == -1 ) return 0; // 타겟이 words에 없는 경우 변환 불가
        
        return bfs(begin, target);
    }
    
    int bfs(String begin, String target) {
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        
        while(!q.isEmpty()) {
            String cur = q.poll();
            int curIdx = indexOf(cur);
            int curDist = curIdx == -1 ? 0 : dist[curIdx]; // begin 처리 : 0
            
            if(cur.equals(target)) return dist[indexOf(cur)]; // 종료
            
            for(int i = 0; i < cur.length(); i ++) {
                for(Character a : alphas) {
                    String next = replaceCharAt(cur, i, a);
                    if(canVisit(next)) {
                        dist[indexOf(next)] = curDist + 1;
                        q.add(next);
                    }
                }
            }
        }
        
        return 0;        
    }
    
    boolean canVisit(String word) {
        int index = indexOf(word);
        return index != -1 && dist[index] == 0;
    }
    
    int indexOf(String word) {
        int index = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word)) {
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    String replaceCharAt(String str, int index, Character newChar) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(index, newChar);
        return sb.toString();
    }
}

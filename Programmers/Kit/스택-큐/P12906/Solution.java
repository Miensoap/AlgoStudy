import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        
        List<Integer> result = new ArrayList<>();
        int now = -1;
        for(int n : arr) {
            if(now == n) continue;
            result.add(n);
            now = n;
        }

        return result;
    }
}
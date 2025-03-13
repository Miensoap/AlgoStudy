import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> cate = new HashMap<>();
        
        for(String[] cloth: clothes) {
            String now = cloth[1];
            cate.put(now, cate.getOrDefault(now, 0) + 1);
        }

        
        int result = 1;
        for(Integer size : cate.values()) {
            result *= (size + 1);
        }
        return result - 1;
    }
}

// 0 ~ n = n + 1 가지 (종류별) 각 종류 가지수 곱하고 아무것도 안입은거 1 빼면됨
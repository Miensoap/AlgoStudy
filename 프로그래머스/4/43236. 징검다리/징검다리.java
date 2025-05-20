import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        
        // mid는 최소 간격이라고 가정
        while(left <= right) {
            int mid = (left + right) / 2;
            // 해당 간격보다 좁은 돌들은 지워졌다고 가정하고 계산
            int removed = getCount(rocks, distance, mid);
            
            if(removed <= n) {
                answer = mid;
                left = mid + 1;     // 더 큰 최소 거리 가능한지 탐색
            } else {
                right = mid - 1;    // 돌을 너무 많이 제거함 → 간격 줄이기
            }
        }
        
        return answer;
    }
    
    // 지운 돌의 개수 계산
    int getCount(int[] rocks, int distance, int mid) {
        int before = 0;
        int remove = 0;
        int end = distance;
        
        for(int i = 0; i < rocks.length; i++) {
            if(rocks[i] - before < mid) { // 간격이 mid보다 작다면 제거
                remove ++;
                continue;
            }
            before = rocks[i]; // 아니라면 현재 돌을 before로 설정
        }
        
        if(end - before < mid) {
            remove ++; // 마지막 돌 - 종료지점 간격 처리
        }
        
        return remove;
    }
}
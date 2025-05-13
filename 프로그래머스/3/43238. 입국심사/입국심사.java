import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 0;
        long right = (long) n * times[times.length -1]; // Max 로 줄일수도
        long mid;
        
        while(left <= right) {
            mid = (left + right) / 2;
            long complete = 0;
            
            for(int i = 0; i < times.length; i++) {
                complete += mid / times[i];
            }
            
            if(complete < n) {
                left = mid + 1; // 불가
            } else {
                right = mid - 1; // 가능
                answer = mid;
            }
        }
        
        return answer;
    }
}
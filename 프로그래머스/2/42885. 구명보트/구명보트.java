import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int heavy = people.length - 1; // 1. 무거운 사람을 태운다
        int light = 0; 
        
        int answer = 0;
        while (light <= heavy) {
            // 2. 같이 탈 수 있는 사람을 찾는다 (가득찰때까지)
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            heavy--;
            answer++; // 더 탈수 없다면 출발
        }

        return answer;
    }
}

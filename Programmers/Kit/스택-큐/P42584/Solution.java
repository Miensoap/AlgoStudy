import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        // 각 시간의 인덱스를 스택에 저장
        for (int i = 0; i < len; i++) {
            // 현재 가격이 스택의 마지막 가격보다 낮으면, 하락 시간 계산
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i - idx; // 하락 시간 계산
            }
            stack.push(i); // 현재 인덱스를 스택에 추가
        }
        
        // 남아 있는 인덱스들은 끝까지 가격이 떨어지지 않음
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = len - 1 - idx;
        }
        
        return ans;
    }
}
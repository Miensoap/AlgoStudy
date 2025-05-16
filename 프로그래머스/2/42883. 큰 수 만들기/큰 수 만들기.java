import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (char n : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < n) {
                stack.pop();
                k--; // 앞에서 버릴 숫자 (가능한 한 큰 수가 맨 앞에 오도록)
            }
            stack.push(n);
        }

        // 가장 큰 수가 일찍 정해져 k가 남았다면 뒤에서 버림
        while (k-- > 0) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}

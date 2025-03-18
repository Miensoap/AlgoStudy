import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char g = s.charAt(i); 
            
            if (stack.isEmpty()) {
                stack.push(g);
            } else if (g == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(g);
            }
        }
        
        return stack.isEmpty();
    }
}

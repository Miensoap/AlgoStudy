package BaekJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(cutSticks(input));
    }

    private static int cutSticks(String input) {
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            if (input.charAt(i) == ')') {
                stack.pop();

                if (input.charAt(i - 1) == '(') { // 직전이 열린 괄호면 레이저
                    result += stack.size(); // stack 에 남아있는 막대 시작들
                } else { // 직전이 닫힌 괄호면 막대 끝
                    result++; // 막대 1개 ++
                }
            }
        }
    return result;
    }

}




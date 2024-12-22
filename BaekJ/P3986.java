package BaekJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int goodWord=0;

        for (int i = 0; i < n; i++) {
            String now = br.readLine();
            st = new StringTokenizer(now, "AB", true);
            if(isGood(st)) goodWord++;
        }
        System.out.println(goodWord);
    }

    private static Boolean isGood(StringTokenizer st) {
        Stack<String> stk = new Stack<>();
        int cnt = 0;

        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (stk.empty()) {
                stk.push(next);
            } else if (stk.peek().equals(next)) {
                stk.pop();
            } else stk.push(next);
        }
        return stk.empty();
    }
}



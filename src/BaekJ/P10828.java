package BaekJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stk = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    stk.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(stk.empty()) sb.append(-1).append("\n");
                    else sb.append(stk.pop()).append("\n");
                    break;
                case "top":
                    if(stk.empty()) sb.append(-1).append("\n");
                    else sb.append(stk.peek()).append("\n");
                    break;
                case "size":
                    sb.append(stk.size()).append("\n");
                    break;
                case "empty":
                    if(stk.empty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}


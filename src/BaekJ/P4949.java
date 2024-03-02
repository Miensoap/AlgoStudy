package BaekJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

       while(true){
           String now = br.readLine();
           if(now.equals(".")) break;
           st = new StringTokenizer(now, "[()]",true);
           System.out.println(isVPS(st));
        }
    }

    private static String isVPS(StringTokenizer st){
        Stack<String> stk = new Stack<>();

        while (st.hasMoreTokens()){
            String next = st.nextToken();
            switch (next) {
                case "(":
                case "[":
                    stk.push(next);
                    break;
                case ")":
                    if (stk.empty() || !stk.peek().equals("(")) return ("no");
                    stk.pop();
                    break;
                case "]":
                    if (stk.empty() || !stk.peek().equals("[")) return ("no");
                    stk.pop();
                    break;
            }

        }
        if(stk.isEmpty()) return("yes");
        else return ("no");
    }
}

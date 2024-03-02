package BaekJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int i=1; i<=n; i++){
            queue.add(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            cnt++;
            if(cnt==k) {
                cnt = 0;
                sb.append(cur+", ");
                continue;
            }
            queue.add(cur);
        }
        sb.replace(sb.length()-2, sb.length()-1, ">");
        System.out.println(sb);

    }
}


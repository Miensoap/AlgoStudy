package BaekJ.P2665;

import java.util.*;
 
public class Main {
    
    static int n;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dist;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        n = scan.nextInt();
        scan.nextLine();
        scan.close();

        board = new int[n][n];
        dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            String temp = scan.nextLine();
            for(int j = 0; j < n; j++) {
                board[i][j] = temp.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        bfs();
        System.out.println(dist[n - 1][n - 1]);
    }
    
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        dist[0][0] = 0;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                boolean inRange = nx >= 0 && ny >= 0 && nx < n && ny < n;
                boolean cheaper = dist[nx][ny] > dist[current.x][current.y];

                if(inRange && cheaper) {
                    if(board[nx][ny] == 1) dist[nx][ny] = dist[current.x][current.y];
                    else dist[nx][ny] = dist[current.x][current.y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    static void dfs() {
        
    }
    
    public static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


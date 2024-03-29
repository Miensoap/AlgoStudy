package CodeTree.Ch2.Meet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n , m;
    static List<Integer> nnow = new ArrayList<>();
    static List<Integer> mnow = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int now = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(reader.readLine());
            String dir = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++){
                now+=move(dir);
                nnow.add(now);
            }
        }

        now=0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(reader.readLine());
            String dir = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++){
                now+=move(dir);
                mnow.add(now);
            }
        }


        for(int i=0; i<nnow.size(); i++){
            int nw = nnow.get(i);
            int mw = mnow.get(i);
            if (nw==mw) {
                System.out.println(i+1);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }


    private static int move(String dir){
        if (dir.equals("R"))
            return 1;
        else
            return -1;
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int v = 0;
        int idx = 0;
        int cnt = 0;

        while(idx+2*(v+1) <= x ){
            v+=1;
            idx += 2*v;
            cnt +=2;
        }
        
        // 최고속도로 한번
        if(idx + v + 1 < x){
            idx += v + 1;
            cnt += 1;
            v += 1;
        }

        if (idx == x) System.out.println(cnt);
        else System.out.println(cnt+1);
    }


}
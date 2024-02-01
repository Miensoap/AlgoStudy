import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        int cnt = 0;
        String tmp;

        for(int i=0; i<input.length-1; i++){
            if((int)input[i].charAt(0)>(int)input[i+1].charAt(0)){
                tmp = input[i];
                input[i] = input[i+1];
                input[i+1] = tmp;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
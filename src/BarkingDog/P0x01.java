package BarkingDog;

import java.util.Arrays;

public class P0x01 {
    public static void main(String[] args) {
        int[] check = new int[101];
        System.out.println(Arrays.toString(check));
    }

    static int func1(int n){
        int sum = 0;

        for(int i=1; i<n; i++){
            if(i%3 == 0 || i%5 ==0){
                sum+=i;
            }
        }

        return sum;
    }

    static int func2(int[] arr, int n){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if (arr[i]+arr[j]==100) return 1;
            }
        }
        return 0;
    }

    static int fun2_2(int[] arr, int n){
        int[] check = new int[101]; // 0으로 자동 초기화
        for(int num : arr){
            if (check[100-num] == 1) return 1;
            check[num] = 1;
        }
        return 0;
    }

    static int func3(int n){
        if (Math.sqrt(n)%1 ==0) return 1;
        return 0;
    }

    static int func4(int n){
        int val =1;
        while(2*val <= n) val*=2;
        return val;
    }
}

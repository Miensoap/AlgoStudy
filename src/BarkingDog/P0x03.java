package BarkingDog;

import java.util.Arrays;

public class P0x03 {
    public static void main(String[] args) {
        int len = 6;
        int[] arr = new int[len];
        insert(3,4,arr);


        System.out.println(Arrays.toString(arr));

    }
    static void insert(int idx, int num, int[] arr){
        for(int i=arr.length-1; i>idx; i--){
            arr[i]=arr[i-1];
        }
        arr[idx] = num;
    }

    static void erase(int idx, int[] arr){
        for(int i = idx; i < arr.length; i++){
            arr[i] = arr[i+1];
        }
    }

}


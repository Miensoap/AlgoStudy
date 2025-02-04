package Algo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
//        String[] arr2 = {"가", "라", "나", "다"};

        printArray(arr, "정렬전");
        printArray(Sort.quickSort(arr), "정렬후");
        printArray(arr, "원본");
    }

    private static <T> void printArray(T[] array, String name) {
        System.out.print(name + " : ");
        printArray(array);
    }

    private static <T> void printArray(T[] array) {
        String joined = Arrays.stream(array)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("[" + joined + "]");
    }
}

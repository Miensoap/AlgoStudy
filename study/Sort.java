package Algo;

import java.util.Arrays;

public abstract class Sort {
    public static <T extends Comparable<T>> T[] quickSort(T[] array) {
        T[] copied = Arrays.copyOfRange(array, 0, array.length);
        return quickSort(copied, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> T[] quickSort(T[] array, int start, int end) {
        int startOfPart2 = partition(array, start, end);

        if (start < startOfPart2 - 1) {
            quickSort(array, start, startOfPart2 - 1);
        }

        if (startOfPart2 < end) {
            quickSort(array, startOfPart2, end);
        }

        return array;
    }

    private static <T extends Comparable<T>> int partition(T[] array, int start, int end) {
        // 1. 중간 인덱스를 선택해 pivot 값으로 사용
        T pivot = array[(start + end) / 2];

        // 2. pivot 값보다 작은 값은 왼쪽으로, 큰 값은 오른쪽으로 이동
        // 두 포인터가 만날때까지 ( pivot 값에서 교차될 때 까지 ) 반복
        while (start <= end) {
            // 2-1. 기준값보다 작은/큰 값인 경우 아무 것도 하지 않고 포인터를 이동
            while (array[start].compareTo(pivot) < 0) start++;
            while (array[end].compareTo(pivot) > 0) end--;

            // 2-2. 더 이동할 수 있는 경우 두 값을 교체하고 이동
            if (start <= end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }

        // 3. 결국 두 포인터가 서로 지나쳐 start 포인터는 오른쪽 파티션의 첫 번째 인덱스
        return start;
    }

    private static <T> void swap(T[] array, int idx1, int idx2) {
        T temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}

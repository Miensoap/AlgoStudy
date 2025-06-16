import java.util.*;

class Solution {
    int[][] maxDp;
    int[][] minDp;
    String[] arr;

    public int solution(String[] arr) {
        int n = arr.length / 2 + 1;
        this.arr = arr;
        
        // 정중앙 연산자 기준으로 양쪽 최대, 최소 구함
        maxDp = new int[n][n];
        minDp = new int[n][n];

        for (int[] row : maxDp) Arrays.fill(row, Integer.MIN_VALUE);
        for (int[] row : minDp) Arrays.fill(row, Integer.MAX_VALUE);

        return getMax(0, n - 1);
    }

    // 연산자가 +, - 일때 각각 최대 최소가 다름
    
    int getMax(int left, int right) {
        if (maxDp[left][right] != Integer.MIN_VALUE) return maxDp[left][right];
        if (left == right) return Integer.parseInt(arr[left * 2]);

        for (int mid = left; mid < right; mid++) {
            int leftMax = getMax(left, mid);
            int rightMax = getMax(mid + 1, right);
            int leftMin = getMin(left, mid);
            int rightMin = getMin(mid + 1, right);
            String op = arr[mid * 2 + 1];

            if (op.equals("+")) {
                maxDp[left][right] = Math.max(maxDp[left][right], leftMax + rightMax);
            } else {
                maxDp[left][right] = Math.max(maxDp[left][right], leftMax - rightMin);
            }
        }
        return maxDp[left][right];
    }

    int getMin(int left, int right) {
        if (minDp[left][right] != Integer.MAX_VALUE) return minDp[left][right];
        if (left == right) return Integer.parseInt(arr[left * 2]);

        for (int mid = left; mid < right; mid++) {
            int leftMax = getMax(left, mid);
            int rightMax = getMax(mid + 1, right);
            int leftMin = getMin(left, mid);
            int rightMin = getMin(mid + 1, right);
            String op = arr[mid * 2 + 1];

            if (op.equals("+")) {
                minDp[left][right] = Math.min(minDp[left][right], leftMin + rightMin);
            } else {
                minDp[left][right] = Math.min(minDp[left][right], leftMin - rightMax);
            }
        }
        return minDp[left][right];
    }
}

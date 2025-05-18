import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 차량의 진출 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int cameras = 0;
        int lastPos = Integer.MIN_VALUE;

        for (int[] route : routes) {
            int entry = route[0];
            int exit = route[1];

            // 현재 카메라가 이 차량을 단속할 수 없는 경우
            if (lastPos < entry) {
                // 이 차량의 진출 지점에 카메라 설치
                cameras++;
                lastPos = exit;
            }
        }

        return cameras;
    }
}

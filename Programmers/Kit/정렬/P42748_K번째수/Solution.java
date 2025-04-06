import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(c -> {
                    int[] subArray = Arrays.copyOfRange(array, c[0] - 1, c[1]);
                    Arrays.sort(subArray);
                    return subArray[c[2] - 1];
                })
                .toArray();
    }
}

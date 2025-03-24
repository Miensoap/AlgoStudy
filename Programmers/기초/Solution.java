package 기초;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] emergency) {
        int[] sorted = emergency.clone();
        Arrays.sort(sorted);
        reverseArray(sorted);

        int[] result = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            result[i] = getIndexAt(emergency[i], sorted) + 1;
        }

        return result;
    }

    private void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    private int getIndexAt(int target, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

class Solution3 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = this.toMap(participant);
        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1) // 차이는 1
                .findAny()
                .get().getKey();
    }

    Map<String, int[]> directions = new HashMap<>();

    {
        directions.put("up", new int[]{0, 1});
        directions.put("down", new int[]{0, -1});
        directions.put("left", new int[]{-1, 0});
        directions.put("right", new int[]{1, 0});
    }

    public int[] solution(String[] keyinput, int[] boardSize) {
        int x = 0;
        int y = 0;

        int maxX = boardSize[0] - 1;
        int maxY = boardSize[1] - 1;

        for (String key : keyinput) {
            x += directions.get(key)[0];
            y += directions.get(key)[1];

            // 위치가 보드 범위를 벗어나지 않도록 보정(클램핑)
            if (x > maxX) x = maxX;
            if (x < -maxX) x = -maxX;
            if (y > maxY) y = maxY;
            if (y < -maxY) y = -maxY;
        }

        return new int[]{x, y};
    }

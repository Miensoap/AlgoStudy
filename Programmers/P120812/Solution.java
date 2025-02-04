package P120812;

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

    public int solution(String before, String after) {
        return Arrays.stream(before.split("")).sorted().collect(Collectors.joining())
                .equals(Arrays.stream(after.split("")).sorted().collect(Collectors.joining())) ? 1 : 0;
    }

    public int solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("[^0-9]", " ")
                        .split(" "))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public String solution2(String bin1, String bin2) {
        return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
    }

    public int solution2(String[] spell, String[] dic) {
        String voca = Arrays.stream(spell).sorted().collect(Collectors.joining());
        return Arrays.stream(dic).anyMatch(s -> Arrays.stream(s.split("")).sorted().collect(Collectors.joining()).equals(voca)) ? 1 : 2;
    }

    public int solution(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce(0, (acc, nb) -> acc + this.remove3(nb + acc))
                + n;
    }

    private int remove3(int number) {
        int plus = 0;

        while ((number + plus) % 3 == 0
                || String.valueOf(number + plus).contains("3")) {
            plus += 1;
        }

        return plus;
    }


    private Map<String, Integer> toMap(String[] array) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        return map;
    }

    private boolean isSolo(String s, String target) {
        return s.replace(target, "").length() + 1 == s.length();
    }

    private boolean isSosu(int n) {
        return getYacsus(n).length == 1;
    }

    private int[] getYacsus(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(i -> n % i == 0)
                .toArray();
    }

    private int factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce(1, (i, num) -> i * num);
    }

    private int countK(int number, int k) {
        return (int) Arrays.stream(String.valueOf(number).split(""))
                .filter(c -> c.equals(String.valueOf(k)))
                .count();
    }

    public int solution(int a, int b) {
        int gcd = gcd(a, b);
        b /= gcd;

        while (b % 2 == 0) {
            b /= 2;
        }
        while (b % 5 == 0) {
            b /= 5;
        }

        return (b == 1) ? 1 : 2;
    }

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public int[] solution(int[] numlist, int n) {
        Integer[] arr = Arrays.stream(numlist).boxed().toArray(Integer[]::new);

        Comparator<Integer> comparator = Comparator
                .comparingInt((Integer x) -> Math.abs(x - n))
                .thenComparing(Comparator.reverseOrder());

        Arrays.sort(arr, comparator);

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }

    static class ScoreWithIndex {
        int sum;
        int index;

        ScoreWithIndex(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int[] solution(int[][] score) {
        int n = score.length;
        ScoreWithIndex[] arr = new ScoreWithIndex[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ScoreWithIndex(score[i][0] + score[i][1], i);
        }

        Arrays.sort(arr, (a, b) -> b.sum - a.sum);

        int[] rank = new int[n];
        int currentRank = 1;
        rank[arr[0].index] = currentRank;

        for (int i = 1; i < n; i++) {
            if (arr[i].sum == arr[i - 1].sum) {
                rank[arr[i].index] = currentRank;
            } else {
                currentRank = i + 1;
                rank[arr[i].index] = currentRank;
            }
        }

        return rank;
    }

    public String solution(String[] id_pw, String[][] db) {
        Optional<String[]> candidate = Arrays.stream(db).filter(s -> s[0].equals(id_pw[0])).findAny();

        if (candidate.isEmpty()) return "fail";
        if (candidate.get()[1].equals(id_pw[1])) return "login";
        else return "wrong pw";
    }

    public int solution3(String A, String B) {
//        int count = 0;
//        String pushed = A;
//        for (int i = 0; i < A.length(); i++) {
//            if (pushed.equals(B)) return count;
//            pushed = pushString(pushed);
//            count++;
//        }
//
//        if (!pushed.equals(B)) return -1;
//        else return count;

        return (B + B).indexOf(A);
    }

    private String pushString(String origin) {
        return origin.substring(origin.length() - 1) + origin.substring(0, origin.length() - 1);
    }
}

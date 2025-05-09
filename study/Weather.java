package study;

import java.util.*;

public class Weather {
    // 접두사 합 배열을 생성하는 함수
    private static int[] createPrefixSum(List<Integer> weather) {
        int days = weather.size();
        int[] prefixSum = new int[days + 1];
        for (int i = 0; i < days; i++) {
            prefixSum[i + 1] = prefixSum[i] + weather.get(i);
        }
        return prefixSum;
    }
    
    // 특정 구간의 비오는 일수를 계산하는 함수
    private static int getRainCount(int[] prefixSum, int start, int end) {
        return prefixSum[end] - prefixSum[start];
    }
    
    // 주어진 n에 대해 패턴이 유효한지 확인하는 함수
    private static int checkPatternValidity(int[] prefixSum, int totalDays, int n) {
        int targetRainCount = getRainCount(prefixSum, 0, n);
        int correctDays = 0;
        
        // 주기적으로 패턴 확인
        for (int start = 0; start <= totalDays - n; start += n) {
            int currentRainCount = getRainCount(prefixSum, start, start + n);
            if (currentRainCount != targetRainCount) {
                return 0;  // 패턴이 맞지 않으면 0 반환
            }
            correctDays += n;
        }
        
        // 남은 날짜 처리
        int remainingDays = totalDays % n;
        if (remainingDays != 0) {
            int lastRainCount = getRainCount(prefixSum, totalDays - remainingDays, totalDays);
            if (lastRainCount * n != targetRainCount * remainingDays) {
                return 0;  // 비율이 맞지 않으면 0 반환
            }
            correctDays += remainingDays;
        }
        
        return correctDays;
    }
    
    // 메인 솔루션 함수
    public static int solution(List<Integer> weather, int k) {
        int totalDays = weather.size();
        int[] prefixSum = createPrefixSum(weather);
        int maxCorrectDays = 0;
        
        // 가능한 모든 주기(n)에 대해 검사
        for (int n = 1; n <= Math.min(k, totalDays); n++) {
            int correctDays = checkPatternValidity(prefixSum, totalDays, n);
            maxCorrectDays = Math.max(maxCorrectDays, correctDays);
        }
        
        return maxCorrectDays;
    }

    // 테스트 코드
    public static void main(String[] args) {
        List<Integer> weather1 = List.of(1, 0, 1, 0);
        System.out.println("Test 1: " + solution(weather1, 2));  // 출력: 4
        
        List<Integer> weather2 = List.of(1, 1, 0, 1);
        System.out.println("Test 2: " + solution(weather2, 3));  // 출력: 4
        
        List<Integer> weather3 = List.of(1, 0, 0, 1, 0, 0);
        System.out.println("Test 3: " + solution(weather3, 3));  // 출력: 6
    }
}
public class Solution {
    int[] numbers;
    int targetNumber, answer = 0;
        
    public int solution(int[] numbers, int target) {
        targetNumber = target;
        this.numbers = numbers;
        
        findTargetNum(-1 * numbers[0], 1);
        findTargetNum(numbers[0], 1);
        
        return answer;
    }

    /**
     * @param num 지금까지의 계산 결과
     * @param start 탐색을 시작할 위치 (index)
     */
    public void findTargetNum(int num, int start) {
        // 합이 타겟과 같고, 모든 숫자를 사용했으면 종료
        if (num == targetNumber && start == numbers.length) {
            answer++;
            return;
        }

        // 모든 숫자를 사용했으면 종료
        if (start >= numbers.length) return;
        
        // 현재 숫자를 더하거나 빼는 두 가지 경우를 재귀
        findTargetNum(num - numbers[start], start + 1);
        findTargetNum(num + numbers[start], start + 1);
    }
}

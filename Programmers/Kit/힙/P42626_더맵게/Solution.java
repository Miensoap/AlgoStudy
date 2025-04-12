import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> foods = new PriorityQueue<>();
        for(int f : scoville) {
            foods.add(f);
        }


        int count = 0;
        while (foods.peek() < K) {
            int f1 = foods.poll();
            int f2 = foods.poll();

            int blended = f1 + (f2 * 2);
            foods.add(blended);
            count ++;
        }

        return count;
    }
}
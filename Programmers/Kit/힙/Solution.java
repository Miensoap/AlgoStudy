package 힙;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    class DePqueue {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        public void add(int n) {
            min.add(n);
            max.add(n);
        }

        public int pollMax() {
            min.remove(max.peek());
            return max.poll();
        }

        public int pollMin() {
            max.remove(min.peek());
            return min.poll();
        }

        public int peekMin() {
            return min.peek();
        }

        public int peekMax() {
            return max.peek();
        }
    }

    public int[] solution(String[] operations) {
        DePqueue q = new DePqueue();



        for(String op : operations) {
            if(op.startsWith("I")) q.add(Integer.parseInt(op.split("I ")[1]));


            if(q.min.isEmpty()) continue;
            if(op.equals("D 1")) q.pollMax();
            if(op.equals("D -1")) q.pollMin();
        }

        if(q.max.isEmpty()) return new int[]{0,0};
        return new int[]{q.peekMin(), q.peekMax()};
    }
        
}

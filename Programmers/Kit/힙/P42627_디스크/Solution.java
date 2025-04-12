import java.util.*;

class Solution {
    static class Job {
        int id;          // 작업 번호
        int requestTime; // 요청 시각
        int workingTime; // 소요 시간
        
        public Job(int id, int requestTime, int workingTime) {
            this.id = id;
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }
    
    public int solution(int[][] jobs) {
        // disk: 요청 시각 기준 정렬
        PriorityQueue<Job> disk = new PriorityQueue<>(Comparator.comparingInt(j -> j.requestTime));

        // execList: 소요 시간 -> 요청 시각 -> 작업 번호 기준 정렬
        PriorityQueue<Job> execList = new PriorityQueue<>(
            Comparator.comparingInt((Job j) -> j.workingTime)
                      .thenComparingInt(j -> j.requestTime)
                      .thenComparingInt(j -> j.id)
        );
        
        int len = jobs.length;
        for (int i = 0; i < len; i++) {
            disk.add(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        int time = 0;
        int ans = 0;  
        
        while (!disk.isEmpty() || !execList.isEmpty()) {
            // 현재 시각까지 요청된 작업을 실행 큐로
            while (!disk.isEmpty() && time >= disk.peek().requestTime) {
                execList.add(disk.poll());
            }
            
            if (!execList.isEmpty()) {
                // 우선순위가 가장 높은 작업 실행, 끝날때까지 skip
                Job exec = execList.poll();
                time += exec.workingTime;
                ans += time - exec.requestTime;
            } else {
                // 실행할 작업이 없으면 다음 요청 까지 대기
                time = disk.peek().requestTime;
            }
        }
        
        return ans / len;
    }
}
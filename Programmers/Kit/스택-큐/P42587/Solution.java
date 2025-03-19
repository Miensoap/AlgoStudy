import java.util.*;

class Solution {
    class Process {
        int pri;
        int loc;
        
        public Process(int p, int l) {
            this.pri = p;
            this.loc = l;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> processes = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            processes.add(new Process(priorities[i], i));
        }
        
        int count = 0;
        while (true) {
            Process p = processes.poll();
            if(processes.stream().filter((pr) -> pr.pri > p.pri).findAny().isPresent()) {
                processes.add(p);
            }
            
            else {
                count ++;
                if(p.loc == location) return count;
            }
        }
    }
}
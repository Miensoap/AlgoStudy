import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> deploys = new ArrayList<>();
        
        while(!isAllDeployed(progresses)) {
            progress(progresses, speeds);
            int count = deploy(progresses);
            
            if(count > 0) deploys.add(count);
        }
        
        return deploys;
    }
    
    private void progress(int[] progresses, int[] speeds) {
        for(int i = 0; i < progresses.length; i++) {
            if(progresses[i] == -1) continue;
            progresses[i] += speeds[i];
        }
    }
    
    private int deploy (int[] progresses) {
        int count = 0;
        for(int i = 0; i < progresses.length; i++) {
            if(progresses[i] == -1) continue;
            if(progresses[i] < 100) break; // 앞 작업이 100이 안되면 뒤도 배포 불가
            // 배포가능
            count +=1;
            progresses[i] = -1;
        }
        
        return count;
    }
    
    private boolean isAllDeployed(int[] progresses) {
        for(int i : progresses) {
            if(i != -1) return false;
        }
        return true;
    }
}
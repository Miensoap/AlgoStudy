import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(Integer.valueOf(n));
        }
        
        return Math.min(nums.length / 2 , set.size());
    }
}
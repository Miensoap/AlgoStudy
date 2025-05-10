class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int x = 3; true; x++) {
            for(int y = 3; y <= x; y++) {
                int cur = x * y;
                if(x * y == total && (x-2)*(y-2) == yellow) return new int[]{x, y};   
            }
        }
    }
}
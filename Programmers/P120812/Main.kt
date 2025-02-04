package P120812

class Solution2 {
    fun solution(hp: Int): Int {
        var hpp = hp;

        var count = 0;
        while (hpp > 0) {
            if (hpp >= 5) hpp -= 5;
            else if (hpp >= 3) hpp -= 3;
            else hpp--;

            count++;
        }

        return count;
    }
}



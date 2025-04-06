package P42747_HIndex

class Solution {
    fun solution(citations: IntArray): Int {
        citations.sortDescending()
        for (i in citations.indices) {
            if (citations[i] <= i) {
                return i
            }
        }
        return citations.size
    }

    // const : 0 <= h < 1000
}

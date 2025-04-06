package P42746_가장큰수

class Solution {
    fun solution(numbers: IntArray): String {
        val sortedNumbers = numbers.map(Int::toString)
            .sortedWith(Comparator { a, b -> (b + a).compareTo(a + b) })

        if (sortedNumbers[0] == "0") return "0"

        return sortedNumbers.joinToString("")
    }
}

fun main() {
    val solution = Solution()
    val numbers = intArrayOf(3, 30, 34, 5, 9)
    println(solution.solution(numbers))  // 출력: 9534330

    val zeros = intArrayOf(0, 0, 0, 0);
    println(solution.solution(zeros))  // 출력: 0
}

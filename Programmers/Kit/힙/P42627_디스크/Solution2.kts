import java.util.PriorityQueue

class Solution2 {
    
    data class Job(val requestTime: Int, val workingTime: Int) : Comparable<Job> {
        override fun compareTo(other: Job): Int {
            return if (this.requestTime == other.requestTime) {
                this.workingTime - other.workingTime
            } else {
                this.requestTime - other.requestTime
            }
        }
    }
    
    fun solution(jobs: Array<IntArray>): Int {
        val disk = PriorityQueue<Job>() // 요청 대기
        val len = jobs.size
        
        for (job in jobs) {
            disk.add(Job(job[0], job[1]))
        }
        
        var time = 0
        var ans = 0
        val execList = PriorityQueue<Job>() // 실행 대기
        
        while (disk.isNotEmpty() || execList.isNotEmpty()) {
            while (disk.isNotEmpty() && time >= disk.peek().requestTime) {
                execList.add(disk.poll())
            }

            if (execList.isNotEmpty()) {
                val exec = execList.poll()
                time += exec.workingTime // 작업 소요 시간만큼 시간 증가
                ans += time - exec.requestTime // 대기 시간 계산
            } else {
                // 대기 중인 작업이 없으면 다음 요청 시간으로 이동
                time = disk.peek().requestTime
            }
        }
        
        return ans / len // 평균 대기 시간 반환
    }
}

fun main() {
    val solution = Solution2()
    
    // 테스트 케이스
    val jobs1 = arrayOf(
        intArrayOf(0, 3),
        intArrayOf(1, 9), 
        intArrayOf(2, 6)
    )
    println("평균 대기 시간: ${solution.solution(jobs1)}") // 예상 출력: 9
    
    val jobs2 = arrayOf(
        intArrayOf(0, 10),
        intArrayOf(2, 3),
        intArrayOf(9, 3)
    )
    println("평균 대기 시간: ${solution.solution(jobs2)}") // 예상 출력: 9
    
    val jobs3 = arrayOf(
        intArrayOf(1, 10),
        intArrayOf(3, 3),
        intArrayOf(10, 3)
    )
    println("평균 대기 시간: ${solution.solution(jobs3)}") // 예상 출력: 9
}
class Solution {
    var result = 9
    var target = 0

    fun solution(N: Int, number: Int): Int {
        var answer = 0

        target = number
        calc(N,0,0)

        if (result == 9) {
            return -1
        }
        return result

    }

    fun calc(n: Int, cnt: Int, current: Int){
        if(cnt > 8) return
        

        if(current == target){
            result = Math.min(result,cnt)
            return
        }

        var nextNum = n
        for (i in 0 until 8 - cnt) {
            calc(n, cnt+1 + i, current + nextNum)
            calc(n, cnt+1 + i, current - nextNum)
            calc(n, cnt+1 + i, current * nextNum)
            calc(n, cnt+1 + i, current / nextNum)
            nextNum += n * Math.pow(10.0, i + 1.toDouble()).toInt()
        }

    }
}
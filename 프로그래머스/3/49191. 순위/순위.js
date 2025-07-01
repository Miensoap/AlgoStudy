function solution(n, results) {
    const graph = Array.from({ length: n + 1 }, () => Array(n + 1).fill(false));

    // 1. 초기 승패 입력
    for (const [win, lose] of results) {
        graph[win][lose] = true;
    }

    // 2. 플로이드-워셜 (전이성 판단)
    for (let k = 1; k <= n; k++) {
        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= n; j++) {
                // 간접 승패 : A가 B를 이기고 B가 C를 이기면 A는 C를 이긴다
                if (graph[i][k] && graph[k][j]) {
                    graph[i][j] = true;
                }
            }
        }
    }

    // 3. 정확한 순위를 아는 선수 수 세기
    let answer = 0;
    for (let i = 1; i <= n; i++) {
        let count = 0;
        for (let j = 1; j <= n; j++) {
            if (graph[i][j] || graph[j][i]) count++;
        }
        if (count === n - 1) answer++; // 다른 모든 선수와 승/패 관계가 있으면 순위 확정
    }

    return answer;
}

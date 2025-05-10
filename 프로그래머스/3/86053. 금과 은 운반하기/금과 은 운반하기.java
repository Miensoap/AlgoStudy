class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        // 시간 기준으로 이분탐색 -> 가능한 최소값을 구함
        // 최대시간 : w = 1인 트럭이 혼자 왕복해서 최대 양을 옮기는 시간
        long maxMaterial = 2L * 1_000_000_000L;
        long maxRoundTripTime = 2 * 100_000;
        long right = maxMaterial * maxRoundTripTime;
        // long right = Long.MAX_VALUE; // log 2^63− 1 = 63?
        long left = 0;

        while (left < right) {
            long mid = (left + right) / 2;

            if (isEnough(mid, a, b, g, s, w, t)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isEnough(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long totalGold = 0;
        long totalSilver = 0;
        long totalCombined = 0;
        
        // 각 도시에서 해당 시간동안 최대로 옮길 수 있는 양 누적
        for (int i = 0; i < g.length; i++) {
            long roundTrip = 2L * t[i];
            long trips = time / roundTrip;

            // 가능하면 편도 한 번 추가
            if (time % roundTrip >= t[i]) trips++;

            long maxTransport = trips * w[i];

            long gold = Math.min(g[i], maxTransport);
            long silver = Math.min(s[i], maxTransport);
            long combined = Math.min(g[i] + s[i], maxTransport);

            totalGold += gold;
            totalSilver += silver;
            totalCombined += combined;
        }

        return (totalGold >= a) && (totalSilver >= b) && (totalCombined >= a + b);
    }
}

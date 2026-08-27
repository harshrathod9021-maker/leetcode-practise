class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {

        int min = 1;
        int max = 10_000_000;

        int ans = -1;

        while (min <= max) {

            int mid = min + (max - min) / 2;

            double time = 0;

            // All trains except the last
            for (int i = 0; i < dist.length - 1; i++) {
                time += Math.ceil((double) dist[i] / mid);
            }

            // Last train: no ceiling
            time += (double) dist[dist.length - 1] / mid;

            if (time <= hour) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }
}
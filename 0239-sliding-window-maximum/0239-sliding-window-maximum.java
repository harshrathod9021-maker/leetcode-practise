import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        // Max Heap: {value, index}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        for (int i = 0; i < n; i++) {

            // Add current element
            pq.offer(new int[]{nums[i], i});

            // Remove elements that are outside the current window
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            // Store answer when the first window is complete
            if (i >= k - 1) {
                ans[i - k + 1] = pq.peek()[0];
            }
        }

        return ans;
    }
}
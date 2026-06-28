class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int mn = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                mn = Math.min(mn, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return mn == Integer.MAX_VALUE ? 0 : mn;
    }
}
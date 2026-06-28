import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 has occurred once initially
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int remainder = sum % k;

            // Handle negative remainders
            if (remainder < 0) {
                remainder += k;
            }

            // Add the number of previous occurrences
            count += map.getOrDefault(remainder, 0);

            // Increase frequency
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
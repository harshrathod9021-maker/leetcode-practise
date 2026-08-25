import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        // Count frequency
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        int k = nums.length / 2;

        // Check which number occurs more than n/2 times
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {

            if (entry.getValue() > k) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
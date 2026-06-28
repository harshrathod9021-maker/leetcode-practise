class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int co =0;
        int mo = 0;
        for (int j = 0; j < nums.length; j++) {
    if (nums[j] == 1) {
        co++;
    } else {
        mo = Math.max(co, mo);
        co = 0;
    }
}

mo = Math.max(co, mo);
return mo;
        
    }
}
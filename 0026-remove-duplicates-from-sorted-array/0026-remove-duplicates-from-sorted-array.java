class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int unique = 1;
        int i = 0;
        for(int j = 1;j<nums.length;j++){
            if(nums[j] == nums[j-1]){
                
                continue;
            }
            nums[i+1] = nums[j];
            i++;
            unique++;
        }
        return unique;
        
    }
}
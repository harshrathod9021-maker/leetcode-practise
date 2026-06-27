class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        if(height.length == 0){
            return 0;
        }
        int max = 0;
        int curr = 0;
        while(i<j){
            int k = Math.min(height[i],height[j]);
            int width = j-i;
            curr = k*width;
            max = Math.max(curr,max);
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }


        }
        return max;

        
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2];
        Arrays.fill(arr,-1);
        arr[0] = firstOccurrence(nums,target);
        arr[1] = lastOccurrence(nums,target);

        return arr;


        
    }
     public static  int firstOccurrence(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            }

            else if (nums[mid] < target) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        return ans;
    }

     public int lastOccurrence(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;
            }

            else if (nums[mid] < target) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
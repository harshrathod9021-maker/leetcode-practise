class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] result = new int[k];

        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        for (int i = start; i <= end; i++) {

            int[] a = maxArray(nums1, i);
            int[] b = maxArray(nums2, k - i);

            int[] candidate = merge(a, b);

            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }

        return result;
    }

    // Greedy + Stack
    private int[] maxArray(int[] nums, int k) {

        int[] stack = new int[k];
        int top = 0;

        int remove = nums.length - k;

        for (int num : nums) {

            while (top > 0 &&
                   stack[top - 1] < num &&
                   remove > 0) {

                top--;
                remove--;
            }

            if (top < k) {
                stack[top++] = num;
            } else {
                remove--;
            }
        }

        return stack;
    }

    // Merge two maximum subsequences
    private int[] merge(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int r = 0;

        while (i < a.length || j < b.length) {

            if (greater(a, i, b, j)) {
                result[r++] = a[i++];
            } else {
                result[r++] = b[j++];
            }
        }

        return result;
    }

    // Compare two arrays from given positions
    private boolean greater(int[] a, int i, int[] b, int j) {

        while (i < a.length && j < b.length) {

            if (a[i] > b[j]) {
                return true;
            }

            if (a[i] < b[j]) {
                return false;
            }

            i++;
            j++;
        }

        return (a.length - i) > (b.length - j);
    }
}
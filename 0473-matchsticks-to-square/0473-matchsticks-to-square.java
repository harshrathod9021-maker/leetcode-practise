class Solution {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int x : matchsticks)
            sum += x;

        // Total length must be divisible by 4
        if (sum % 4 != 0)
            return false;

        int target = sum / 4;

        // Sort in descending order (optimization)
        Arrays.sort(matchsticks);

        reverse(matchsticks);

        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, target);
    }

    private boolean backtrack(int[] matchsticks,
                              int index,
                              int[] sides,
                              int target) {

        // All matchsticks are used
        if (index == matchsticks.length)
            return true;

        int stick = matchsticks[index];

        for (int i = 0; i < 4; i++) {

            // Cannot exceed target side length
            if (sides[i] + stick > target)
                continue;

            // Choose
            sides[i] += stick;

            // Explore
            if (backtrack(matchsticks, index + 1, sides, target))
                return true;

            // Backtrack
            sides[i] -= stick;

            // Optimization:
            // If placing the stick on an empty side doesn't work,
            // trying other empty sides will also fail.
            if (sides[i] == 0)
                break;
        }

        return false;
    }

    private void reverse(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
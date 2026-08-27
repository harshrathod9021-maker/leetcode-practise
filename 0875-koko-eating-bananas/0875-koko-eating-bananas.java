import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int ans = max;

        while (min <= max) {

            int mid = min + (max - min) / 2;

            long hours = 0;

            for (int pile : piles) {

                hours += ((long) pile + mid - 1) / mid;

            }

            if (hours <= h) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }
}
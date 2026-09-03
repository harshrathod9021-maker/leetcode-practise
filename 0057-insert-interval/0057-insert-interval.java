import java.util.*;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();

        int i = 0;

        // Add all intervals that come before newInterval
        while (i < intervals.length &&
               intervals[i][1] < newInterval[0]) {

            list.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < intervals.length &&
               intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        // Add the merged newInterval
        list.add(newInterval);

        // Add remaining intervals
        while (i < intervals.length) {

            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
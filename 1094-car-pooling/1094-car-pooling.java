import java.util.*;

class Solution {

    public boolean carPooling(int[][] trips, int capacity) {

        // Store pickup and drop-off events
        ArrayList<int[]> events = new ArrayList<>();

        for (int i = 0; i < trips.length; i++) {

            int passengers = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            // Pickup
            events.add(new int[]{from, passengers});

            // Drop-off
            events.add(new int[]{to, -passengers});
        }

        // Sort according to location
        // If same location, drop-off (-passengers) comes first
        Collections.sort(events, (a, b) -> {

            if (a[0] == b[0]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        int passengers = 0;

        // Greedy
        for (int i = 0; i < events.size(); i++) {

            passengers += events.get(i)[1];

            if (passengers > capacity) {
                return false;
            }
        }

        return true;
    }
}
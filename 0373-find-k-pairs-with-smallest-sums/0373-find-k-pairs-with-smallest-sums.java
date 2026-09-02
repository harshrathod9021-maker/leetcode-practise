class Solution {

    public List<List<Integer>> kSmallestPairs(
            int[] nums1,
            int[] nums2,
            int k) {

        // Min Heap
        // int[0] = value from nums1
        // int[1] = value from nums2
        // int[2] = index in nums2

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>(
                (a, b) ->
                    (a[0] + a[1]) - (b[0] + b[1])
            );

        // Put the first pair of each nums1 row
        for (int i = 0;
             i < nums1.length && i < k;
             i++) {

            minHeap.add(
                new int[]{
                    nums1[i],
                    nums2[0],
                    0
                }
            );
        }

        List<List<Integer>> result =
            new ArrayList<>();

        // Get k smallest pairs
        for (int i = 0;
             i < k && !minHeap.isEmpty();
             i++) {

            // Get smallest pair
            int[] curr = minHeap.poll();

            // Add pair to result
            result.add(
                List.of(curr[0], curr[1])
            );

            // Current index in nums2
            int nums2Idx = curr[2];

            // Move to next element in nums2
            if (nums2Idx < nums2.length - 1) {

                minHeap.add(
                    new int[]{
                        curr[0],
                        nums2[nums2Idx + 1],
                        nums2Idx + 1
                    }
                );
            }
        }

        return result;
    }
}
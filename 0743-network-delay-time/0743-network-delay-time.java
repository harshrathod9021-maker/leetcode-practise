class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[]{v, w});
        }

        // Min Heap: {node, distance}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currNode = curr[0];
            int currDist = curr[1];

            // Ignore outdated entry
            if (currDist > dist[currNode]) {
                continue;
            }

            for (int[] neighbor : graph.get(currNode)) {

                int v = neighbor[0];
                int wt = neighbor[1];

                // Relaxation
                if (dist[currNode] + wt < dist[v]) {

                    dist[v] = dist[currNode] + wt;

                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // Find maximum shortest distance
        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
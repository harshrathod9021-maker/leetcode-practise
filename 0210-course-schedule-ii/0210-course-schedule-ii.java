class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph and calculate indegree
        for (int[] edge : prerequisites) {

            int course = edge[0];
            int prerequisite = edge[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> que = new LinkedList<>();

        // Add courses with no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }

        int[] answer = new int[numCourses];
        int index = 0;

        // Kahn's Algorithm
        while (!que.isEmpty()) {

            int curr = que.poll();

            answer[index++] = curr;

            // Process dependent courses
            for (int neighbor : graph.get(curr)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    que.offer(neighbor);
                }
            }
        }

        // If not all courses were processed, a cycle exists.
        if (index != numCourses) {
            return new int[0];
        }

        return answer;
    }
}
import java.util.*;

class Task {

    int frequency;
    int executionTime;

    Task(int f, int t) {
        frequency = f;
        executionTime = t;
    }

    // Max Heap based on frequency
    public int compareTo(Task that) {
        return that.frequency - this.frequency;
    }
}

class Solution {

    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count frequency of every task
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : tasks) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap
        PriorityQueue<Task> pq = new PriorityQueue<>(
            (a, b) -> b.frequency - a.frequency
        );

        // Insert all tasks into PriorityQueue
        for (Character ch : freqMap.keySet()) {

            int freq = freqMap.get(ch);

            pq.offer(new Task(freq, 0));
        }

        // Queue for tasks that are cooling down
        Queue<Task> queue = new LinkedList<>();

        int time = 0;

        // Continue until both queues are empty
        while (!queue.isEmpty() || !pq.isEmpty()) {

            time++;

            // Check if there is a task in PQ and process it
            if (!pq.isEmpty()) {

                Task task = pq.poll();

                task.frequency--;

                if (task.frequency > 0) {

                    // Update the execution time
                    task.executionTime = time + n;

                    // Put task into cooldown queue
                    queue.offer(task);
                }
            }

            // Shift the active process to the PQ
            if (!queue.isEmpty()
                    && queue.peek().executionTime == time) {

                pq.offer(queue.poll());
            }
        }

        return time;
    }
}
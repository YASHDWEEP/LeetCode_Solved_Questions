class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {

        boolean[] visited = new boolean[1001];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        int operations = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int current = queue.poll();

                if (current == goal) {
                    return operations;
                }

                for (int num : nums) {

                    int next1 = current + num;
                    int next2 = current - num;
                    int next3 = current ^ num;

                    if (next1 == goal || next2 == goal || next3 == goal) {
                        return operations + 1;
                    }

                    if (next1 >= 0 && next1 <= 1000 && !visited[next1]) {
                        visited[next1] = true;
                        queue.offer(next1);
                    }

                    if (next2 >= 0 && next2 <= 1000 && !visited[next2]) {
                        visited[next2] = true;
                        queue.offer(next2);
                    }

                    if (next3 >= 0 && next3 <= 1000 && !visited[next3]) {
                        visited[next3] = true;
                        queue.offer(next3);
                    }
                }
            }

            operations++;
        }

        return -1;
    }
}
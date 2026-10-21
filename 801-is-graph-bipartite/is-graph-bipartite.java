class Solution {
       public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);                     // -1 = uncolored

        for (int s = 0; s < n; s++) {               // handles disconnected graphs
            if (color[s] != -1) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            color[s] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int v : graph[node]) {
                    if (color[v] == -1) {           // unvisited: give opposite color
                        color[v] = 1 - color[node];
                        q.add(v);
                    } else if (color[v] == color[node]) {
                        return false;               // same color on an edge
                    }
                }
            }
        }
        return true;
    }
}


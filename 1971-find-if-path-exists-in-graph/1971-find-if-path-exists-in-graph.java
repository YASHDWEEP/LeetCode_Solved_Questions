class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        boolean vis[] = new boolean[n];
        return dfs(vis, adj, source, destination);
    }

    private boolean dfs(boolean vis[], List<List<Integer>> adj, int source, int destination) {
        if (source == destination) {
            return true;
        }
        vis[source] = true;
        for (int next : adj.get(source)) {
            if (!vis[next]) {
                if (dfs(vis, adj, next, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

}
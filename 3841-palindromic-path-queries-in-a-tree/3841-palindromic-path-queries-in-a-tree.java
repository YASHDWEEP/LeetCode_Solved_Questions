import java.util.*;

class Solution {
    int LOG;
    int[][] up;
    int[] depth, tin, tout, prefix, bit;
    int timer;
    List<Integer>[] adj;
    Fenwick fw;

    class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        void update(int i, int val) {
            for (; i <= n; i += i & -i) {
                tree[i] ^= val;
            }
        }

        void rangeUpdate(int l, int r, int val) {
            update(l + 1, val);
            update(r + 2, val);
        }

        int query(int i) {
            int ans = 0;
            for (i++; i > 0; i -= i & -i) {
                ans ^= tree[i];
            }
            return ans;
        }
    }

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        prefix = new int[n];
        bit = new int[n];

        for (int i = 0; i < n; i++) {
            bit[i] = 1 << (s.charAt(i) - 'a');
        }

        int[] parent = new int[n];
        int[] order = new int[n];
        int[] stack = new int[n];
        Arrays.fill(parent, -1);

        int top = 0, count = 0;
        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            tin[u] = count;
            order[count++] = u;

            prefix[u] =
                    (u == 0 ? 0 : prefix[parent[u]]) ^ bit[u];

            up[0][u] = parent[u];

            for (int v : adj[u]) {
                if (parent[v] != -1) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        int[] size = new int[n];
        Arrays.fill(size, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }

        for (int u = 0; u < n; u++) {
            tout[u] = tin[u] + size[u] - 1;
        }

        for (int k = 1; k < LOG; k++) {
            for (int u = 0; u < n; u++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }

        fw = new Fenwick(n + 1);
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                int newBit = 1 << (p[2].charAt(0) - 'a');

                int delta = bit[u] ^ newBit;

                if (delta != 0) {
                    fw.rangeUpdate(tin[u], tout[u], delta);
                }

                bit[u] = newBit;

            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int lca = getLCA(u, v);

                int pu = prefix[u] ^ fw.query(tin[u]);
                int pv = prefix[v] ^ fw.query(tin[v]);

                int mask = pu ^ pv ^ bit[lca];

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }
}
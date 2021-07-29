package Graphs;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimMST {

    // time complexity - O(V^2)
    public int primMST(int[][] graph, int v) {

        boolean[] mst = new boolean[v];
        int[] key = new int[v];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        int ans = 0;
        for(int count = 0; count < v; count++) {

            int u = -1;
            for(int i=0; i<v; i++) {
                if(!mst[i] && (u==-1 || key[i] < key[u]))
                    u = i;
            }

            mst[u] = true;
            ans += key[u];

            for(int i=0; i<v; i++) {
                if(!mst[i] && graph[u][i]!=0 && graph[u][i] < key[i])
                    key[i] = graph[u][i];
            }
        }

        return ans;
    }

}

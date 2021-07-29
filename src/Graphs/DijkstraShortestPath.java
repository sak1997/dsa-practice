package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

    public int[] dijkstraShortestPath(int[][] graph, int source) {
        int v = graph.length;
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        boolean[] fin = new boolean[v];

        for(int count=0; count<v; count++) {
            int u = -1;
            for(int i=0; i<v; i++) {
                if(!fin[i] && (u==-1 || dist[u] > dist[i]))
                    u = i;
            }

            fin[u] = true;

            for(int i=0; i<v; i++) {
                if(!fin[i] && graph[u][i]!=0 &&
                dist[i] > dist[u] + graph[u][i]) {
                    dist[i] = dist[u] + graph[u][i];
                }
            }

        }

        return dist;
    }

}

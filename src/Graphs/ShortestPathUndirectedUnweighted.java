package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedUnweighted {

    // using BFS since we can go to the immediate next elements from the given source, which means that since it's
    // an undirected unweighted graph, that will be the shortest path from the source
    public int[] ShortestPathsLengths(ArrayList<ArrayList<Integer>> adjlist, int source) {
        boolean[] visited = new boolean[adjlist.size()];
        int[] lengths = new int[adjlist.size()];

        lengths[source] = 0;
        visited[source] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while(!q.isEmpty()) {
            int el = q.poll();
            for(int x : adjlist.get(el)) {
                if(!visited[x]) {
                    lengths[x] = lengths[el] + 1;
                    visited[x] = true;
                    q.add(x);
                }
            }
        }

        return lengths;

    }

}

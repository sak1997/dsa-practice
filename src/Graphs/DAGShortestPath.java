package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DAGShortestPath {

    public List<Integer> topsortadjmatrix(int[][] graph, int v) {

        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> sorted = new ArrayList<>();
        int[] indegree = new int[v];
        for(int i=0; i<v; i++) {
            for(int j=0; j<v; j++) {
                if(graph[i][j] > 0) indegree[j]++;
            }
        }

        for(int i=0; i<v; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int el = q.poll();
            sorted.add(el);
            for(int i=0; i<v; i++) {
                if(graph[el][i] > 0) {
                    indegree[graph[el][i]]--;
                    if(indegree[graph[el][i]] == 0)
                        q.add(indegree[graph[el][i]]);
                }
            }
        }

        return sorted;

    }

    public int[] dagShortestPathSource(int[][] graph, int source, int v) {

        int[] lengths = new int[v];
        List<Integer> topsort = topsortadjmatrix(graph, v);

        for(int i=0; i<v; i++) {
            if(i != source)
                lengths[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<v; i++) {
            int u = topsort.get(i);
            for(int j=0; j<v; j++) {
                if(lengths[j] > lengths[i] + graph[i][j])
                    lengths[j] = lengths[i] + graph[i][j];
            }
        }
        lengths[source] = 0;

        return lengths;

    }

}

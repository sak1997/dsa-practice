package Graphs;

import java.util.List;

public class DetectCycle_DirectedGraph_DFS {

    public boolean checkCycle_DFS(List<List<Integer>> adjlist, int source, boolean[] visited, boolean[] recStack) {

        visited[source] = true;
        recStack[source] = true;

        for(int x : adjlist.get(source)) {
            if(!visited[x]) {
                boolean checkans = checkCycle_DFS(adjlist, x, visited, recStack);
                if(checkans) return checkans;
            } else if(recStack[x]) {
                return true;
            }
        }
        recStack[source] = false;
        return false;
    }

    public boolean checkCycle(List<List<Integer>> adjlist, int v) {

        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        boolean ans = false;

        for(int i=0; i<v; i++) {
            if(!visited[i]) {
               ans = ans || checkCycle_DFS(adjlist, i, visited, recStack);
            }
        }

        return ans;
    }
}

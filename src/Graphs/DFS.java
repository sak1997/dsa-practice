package Graphs;

import java.util.ArrayList;

public class DFS {

    public void DFShelper(ArrayList<ArrayList<Integer>> adjlist, int source, boolean[] visited) {
        if(visited[source])
            return;

        visited[source] = true;
        System.out.print(source + " ");

        for(int x : adjlist.get(source)) {
            if(!visited[x])
                DFShelper(adjlist, x, visited);
        }
        return;
    }

    public void printDFS(ArrayList<ArrayList<Integer>> adjlist) {

        boolean[] visited = new boolean[adjlist.size()];
        for(int i=0; i < adjlist.size(); i++) {
            if(!visited[i])
                DFShelper(adjlist, i, visited);
        }
    }

}

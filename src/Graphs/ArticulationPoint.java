package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPoint {

    int timer;

    public void dfsHelper(List<List<Integer>> adj, boolean[] visited, int source, List<Integer> ap,
                          int[] parent, int[] low, int[] disc) {

        visited[source] = true;

        disc[source] = timer++;
        if(low[source] > disc[source])
            low[source] = disc[source];

        int count = 0;
        for(int x : adj.get(source)) {

            if(!visited[x]) {
                count++;
                if(parent[source] == -1 && count > 1)
                    ap.add(source);

                parent[x] = source;
                dfsHelper(adj, visited, x, ap, parent, low, disc);

                if(parent[source] != -1 && low[x] >= disc[source]) {
                    ap.add(source);
                }
            }

            if(low[source] > disc[x])
                low[source] = disc[x];

        }
        return;
    }

    public List<Integer> articulationPoints(List<List<Integer>> adj) {

        int v = adj.size();
        boolean[] visited = new boolean[v];
        List<Integer> ap = new ArrayList<>();
        int[] parent = new int[v];
        int[] low = new int[v];
        int[] disc = new int[v];

        Arrays.fill(low, Integer.MAX_VALUE);

        timer = 0;

        for(int i=0; i<v; i++) {
            if(!visited[i]) {
                parent[i] = -1;
                low[i] = 1;
                dfsHelper(adj, visited, i, ap, parent, low, disc);
            }
        }

        for(int x : ap)
            System.out.print(x + " ");

        return ap;
    }

    public static void main(String[] arg) {
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0; i<5; i++)
            adjlist.add(new ArrayList<Integer>());
        adjlist.get(0).add(1);
        adjlist.get(1).add(0);

        adjlist.get(0).add(2);
        adjlist.get(2).add(0);

        adjlist.get(1).add(2);
        adjlist.get(2).add(1);

        adjlist.get(2).add(3);
        adjlist.get(3).add(2);

//        adjlist.get(2).add(4);
//        adjlist.get(4).add(2);

        adjlist.get(3).add(4);
        adjlist.get(4).add(3);

        ArticulationPoint apt = new ArticulationPoint();
        List<Integer> aps = apt.articulationPoints(adjlist);


    }

}

package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// implementation of Kosaraju's algorithm to find the strongly
// connected components in a directed graph
public class KosarajuAlgorithm {

    // to build order in the reverse order i.e sinks first then sources
    public void dfsSinkRevOrderBuilder(List<List<Integer>> adjlist, boolean[] visited, Stack<Integer> st,
                                       int source) {

        visited[source] = true;

        for(int x : adjlist.get(source)) {
            if(!visited[x])
                dfsSinkRevOrderBuilder(adjlist, visited, st, x);
        }

        st.push(source);
        return;
    }

    // simple dfs traversal with a line to add the node to a scc list
    public void dfsHelper(List<List<Integer>> adjlist, boolean[] visited, int source, List<Integer> scc) {

        visited[source] = true;
        scc.add(source);
        for(int x : adjlist.get(source))
            if(!visited[x])
                dfsHelper(adjlist, visited, x, scc);
    }

    public List<List<Integer>> kosarajuAlgo(List<List<Integer>> adjlist) {

        int n = adjlist.size();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i])
                dfsSinkRevOrderBuilder(adjlist, visited, st, i);
        }

        List<List<Integer>> revadjlist = new ArrayList<>();
        for(int i=0; i<n; i++)
            revadjlist.add(new ArrayList<>());
        for(int i=0; i<n; i++) {
            for(int x: adjlist.get(i)) {
                revadjlist.get(x).add(i);
            }
        }

        List<List<Integer>> scclist = new ArrayList<>();
        Arrays.fill(visited, false);

        for(int i=0; i<n; i++) {
            int x = st.pop();
            if(!visited[x]) {
                List<Integer> scc = new ArrayList<>();
                dfsHelper(revadjlist, visited, x, scc);
                scclist.add(scc);
            }
        }

        return scclist;
    }

    public static void main(String[] arg) {
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0; i<6; i++)
            adjlist.add(new ArrayList<Integer>());
        adjlist.get(0).add(1);
        adjlist.get(1).add(2);
        adjlist.get(2).add(3);
        adjlist.get(3).add(0);
        adjlist.get(3).add(4);
        adjlist.get(4).add(5);
        adjlist.get(5).add(4);
        /*
          0 -> 3 ->   4
          |   /\    | /\
         \/   |    \/ |
         1 -> 2     5
         scc : {{0, 1, 2, 3}, {4, 5}}
         */

        KosarajuAlgorithm ks = new KosarajuAlgorithm();

        List<List<Integer>> scclist = ks.kosarajuAlgo(adjlist);
        for(List<Integer> xlist : scclist) {
            for(int x : xlist)
                System.out.print(x + " ");
            System.out.println();
        }


    }

}

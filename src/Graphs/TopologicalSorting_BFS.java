package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSorting_BFS {

    // https://leetcode.com/problems/course-schedule-ii/
    // to transform this into a cycle detection algo, just add a counter to see how many elements have been added
    // in the queue and at the end, compare with v

    public static List<Integer> topologicalsort(List<List<Integer>> adjlist, int v) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[v];

        for(int i=0; i<adjlist.size(); i++) {
            for(int x: adjlist.get(i))
                indegree[x]++;
        }

        for(int i=0; i<v; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        //int count = 0
        while(!q.isEmpty()) {
            int el = q.poll();
            ans.add(el);
            for(int x : adjlist.get(el)) {
                indegree[x]--;
                if(indegree[x] == 0) {
                    q.add(x);
                    // count++
                }
            }
        }
        // if(count == v) return true; else return false;
        return ans;

    }

}

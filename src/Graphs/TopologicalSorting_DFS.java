package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting_DFS {

    // need to add cycle detection logic but this is the problem
    // https://leetcode.com/problems/course-schedule-ii/

    public void dfsHelper2(ArrayList<ArrayList<Integer>> adjlist, boolean[] visited, Stack<Integer> s, int source) {

        visited[source] = true;
        for(int x : adjlist.get(source)) {
            if(!visited[x]) {
                dfsHelper2(adjlist, visited, s, x);
            }
        }
        s.push(source);
        return;

    }

    public int[] Topsort(int numCourses, int[][] prerequisites) {


        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<numCourses; i++)
            adjlist.add(new ArrayList<Integer>());
        for(int i=0; i<prerequisites.length; i++) {
            adjlist.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean[] visited = new boolean[numCourses];
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<numCourses; i++) {
            if(!visited[i])
                dfsHelper2(adjlist, visited, s, i);
        }

        int[] ans = new int[numCourses];
        for(int i=0; i<numCourses; i++)
            ans[i] = s.pop();

        return ans;

    }

}

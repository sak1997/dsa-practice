package Backtracking;

public class RatInAMaze {

    static boolean path[][];

    public static boolean ratInAMaze(int maze[][]){

        int n = maze.length;
        path = new boolean[n][n];

        return helper(maze, n, 0, 0);
    }

    public static boolean helper(int maze[][], int n, int i, int j) {

        if(i >=n || j >=n) // out of bounds
            return false;
        if(i < 0 || j < 0) // out of bounds
            return false;
        if(path[i][j] == true) // already explored
            return false;
        if(maze[i][j] == 0) // no maze(or the current position is invalid according to maze) at the current node - backtrack and check somewhere else
            return false;

        path[i][j] = true;

        if(i == n-1 && j == n-1) // destination, return path is possible i.e true
            return true;

        boolean up = helper(maze, n, i-1, j);
        boolean down = helper(maze, n, i+1, j);
        boolean left = helper(maze, n, i, j-1);
        boolean right = helper(maze, n, i, j+1);

        path[i][j] = false;

        return up || down || left || right;
    }

}

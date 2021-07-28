package Backtracking;

public class NQueens {

    public static void placeNQueens(int n) {
        int board[][] = new int[n][n];
        helper(board, n, 0);
        return;
    }

    public static void helper(int board[][], int n, int row) {
        if(row >= n)
            return;

        for(int i=0; i<n; i++) {
            if(checksafe(board, n, row, i)) {
                board[row][i] = 1;
                if(row == n-1)
                    printboard(board, n);
                helper(board, n, row+1);
                board[row][i] = 0;
            }
        }

    }

    public static boolean checksafe(int board[][], int n, int row, int col) {
        if(row >= n || col >=n)
            return false;
        if(row < 0 || col < 0)
            return false;

        for(int i=0; i<n; i++) {
            if(board[i][col] == 1)
                return false;
        }

        for(int j=0; j<n; j++) {
            if(board[row][j] == 1)
                return false;
        }

        for(int i=row, j=col; i<n && j<n; i++, j++) {
            if(board[i][j] == 1)
                return false;
        }

        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 1)
                return false;
        }

        for(int i=row, j=col; i>=0 && j<n; i--, j++) {
            if(board[i][j] == 1)
                return false;
        }

        for(int i=row, j=col; i<n && j>=0; i++, j--) {
            if(board[i][j] == 1)
                return false;
        }

        return true;

    }

    public static void printboard(int board[][], int n) {
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                System.out.print(board[i][j] + " ");
        System.out.println();
        return;
    }
}

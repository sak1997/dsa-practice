package Recursion;

public class TowerOfHanoi {

    /*

    PROBLEM LINK - https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1

    The tower of Hanoi is a famous puzzle where we have three rods and N disks. The objective of the puzzle is to move the entire stack to another rod. You are given the number of discs N. Initially, these discs are in the rod 1. You need to print all the steps of discs movement so that all the discs reach the 3rd rod. Also, you need to find the total moves.
    Note: The discs are arranged such that the top disc is numbered 1 and the bottom-most disc is numbered N. Also, all the discs have different sizes and a bigger disc cannot be put on the top of a smaller disc. Refer the provided link to get a better clarity about the puzzle.

    Example 1:

    Input:
    N = 2
    Output:
    move disk 1 from rod 1 to rod 2
    move disk 2 from rod 1 to rod 3
    move disk 1 from rod 2 to rod 3
    3
    Explanation: For N=2 , steps will be
    as follows in the example and total
    3 steps will be taken.
    Example 2:

    Input:
    N = 3
    Output:
    move disk 1 from rod 1 to rod 3
    move disk 2 from rod 1 to rod 2
    move disk 1 from rod 3 to rod 2
    move disk 3 from rod 1 to rod 3
    move disk 1 from rod 2 to rod 1
    move disk 2 from rod 2 to rod 3
    move disk 1 from rod 1 to rod 3
    7
    Explanation: For N=3 , steps will be
    as follows in the example and total
    7 steps will be taken.
     */

    public static long toh_helper(long n, int from, int to, int aux, int topval) {

        if(n <= 0) {
            return 0;
        }

        if(n == 1) {
            System.out.println("move disk " + topval +" from rod " + from + " to rod " + to);
            return 1;
        }

        long ans = 0;
        ans += toh_helper(n-1, from, aux, to, 1);

        ans += 1;
        System.out.println("move disk " + n +" from rod " + from + " to rod " + to);

        ans += toh_helper(n-1, aux, to, from, 1);

        return ans;

    }

    public static long toh(int n, int from, int to, int aux) {
        // Your code here

        long ans = toh_helper(n, from, to, aux, 1);
        return ans;

    }


    public static void main(String arg[]) {

        System.out.println("Tower of Hanoi Solution for n = 5 is : " + toh(5, 1, 2, 3));

    }

}

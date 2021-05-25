package Recursion;

public class MergeSort {

    public int[] merge(int a[], int b[]) {

        int m = a.length;
        int n = b.length;

        int i=0, j=0;
        int ans[] = new int[m+n];
        int count = 0;

        while(i<m && j<n) {
            if(a[i] <= b[j]) {
                ans[count++] = a[i++];
            } else {
                ans[count++] = b[j++];
            }
        }

        if(j == n) {
            for(int k=i; k<m; k++) {
                ans[count++] = a[k];
            }
        }

        if(i == m) {
            for(int k=j; k<n; k++){
                ans[count++] = b[k];
            }
        }

        return ans;
    }

    public static void main(String arg[]) {

    }

}

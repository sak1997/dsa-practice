package Recursion;

public class MergeSort {

    // A general merge function considering 2 separate arrays as input
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

    // merge function for merge sort
    public static void mergeForMergeSort(int arr[], int start, int mid, int end) {

        // base case given that
        if(end <= start) {
            return;
        }


        int m = mid-start+1;
        int n = end-mid;

        int a[] = new int[m];
        int b[] = new int[n];

        int tmp=0;
        for(int i=start; i<=mid; i++)
            a[tmp++] = arr[i];

        tmp=0;
        for(int i=mid+1; i<=end; i++)
            b[tmp++] = arr[i];

        int i=0, j=0, count = start;

        while(i<m && j<n) {
            if(a[i] <= b[j]) {
                arr[count++] = a[i++];
            } else {
                arr[count++] = b[j++];
            }
        }

        while(i < m) {
            arr[count++] = a[i++];
        }

        while(j < n) {
            arr[count++] = b[j++];
        }

        return;
    }

    public static void mergeSort(int arr[], int start, int end) {

        if(end <= start)
            return;

        int mid = start + (end-start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        mergeForMergeSort(arr, start, mid, end);
        return;

    }

    public static void main(String arg[]) {

        int arr[] = {12, 11, 15, 20, 25, 7, 2, 5, 1};
        mergeSort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++)
            System.out.println(arr[i]);

    }

}

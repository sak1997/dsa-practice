package Recursion;

public class QuickSort {

    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return;
    }

    // Lomuto partition where you do partition in single-pass of the array
    public static int partitionLomuto(int arr[], int start, int end) {

        int pivot = arr[end];

        int i = start-1;
        for(int j=start; j<end; j++) {
            if(arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, ++i, end);

        return i;
    }

    // Hoare partition which is supposed to be better than Lomuto
    // it takes lesser comparisons compared to Lomuto
    public static int partitionHoare(int arr[], int start, int end) {

        int pivot = arr[start];
        int i = start - 1, j = end + 1;

        while(true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while( arr[j] > pivot);

            if(i >= j) {
                return j;
            }

            swap(arr, i, j);
        }


    }

    public static int partition(int arr[], int start, int end) {

        // assume pivot is the number at the start index
        int pivot = start;

        // find elements smaller than pivot and move pivot to that index
        int lenOfSubArr = end - start + 1;
        int countLessPivot = 0;
        for(int i=start; i<=end; i++) {
            if(arr[i] < arr[start]) {
                countLessPivot++;
            }
        }

        //swap pivot which is at the start index with (start + countLessPivot) i.e
        // place it at its correct position in the subarray
        int tmp;
        tmp = arr[pivot];
        arr[pivot] = arr[pivot + countLessPivot];
        arr[pivot + countLessPivot] = tmp;

        // update pivot index
        pivot = pivot + countLessPivot;

        //Now what we need to do is move all the elements smaller than the pivot to the pivot's left
        //and greater elements to the pivot's right
        // for this, we use a 2 pointer approach to swap any element>=pivot on the left with any element<pivot on its right

        int i = start;
        int j = end;

        while(i < pivot && j > pivot) {
            if(arr[i] >= arr[pivot] && arr[j] < arr[pivot]) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            } else if (arr[i] >= arr[pivot]) {
                j--;
            } else if (arr[j] < arr[pivot]) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return pivot;
    }

    public static void quickSort(int arr[], int start, int end) {

        if(end <= start)
            return;

        // partition function will return the pivot position
        int pivot = partitionHoare(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
        return;
    }

    public static void main(String arg[]) {

        int arr[] = {12, 11, 15, 20, 25, 7, 2, 5, 1};
        quickSort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");

    }
}

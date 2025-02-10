package sortinglargedataefficiently;

import java.util.Random;

public class SortingLargeDataEfficiently {
    //Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    //Merge Sort
    static void mergeSort(int[] arr, int si, int end) {
        if (si >= end) return;

        int mid = si + (end - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, si, mid, end);
    }

    //Merge function for merge sort
    static void merge(int[] arr, int si, int mid, int end) {
        int[] temp = new int[end - si + 1];

        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // 🔹 Median-of-Three function
    static int medianOfThree(int[] arr, int si, int end) {
        int mid = si + (end - si) / 2;

        // Swap to ensure arr[mid] is the median of (arr[si], arr[mid], arr[end])
        if (arr[si] > arr[mid]) swap(arr, si, mid);
        if (arr[si] > arr[end]) swap(arr, si, end);
        if (arr[mid] > arr[end]) swap(arr, mid, end);

        swap(arr, mid, end);
        return end;  // New pivot index
    }


    // 🔹 Swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static void quickSort(int[] arr, int si, int end) {
        if (si >= end) {
            return;
        }
        int pivotIdx = medianOfThree(arr, si, end);
        int pIdx = partition(arr, si, end);
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, end);
    }

    static int partition(int[] arr, int si, int end) {
        int pivot = arr[end];
        int low = si - 1;

        for (int j = si; j < end; j++) {
            if (arr[j] <= pivot) {
                low++;
                int temp = arr[j];
                arr[j] = arr[low];
                arr[low] = temp;
            }
        }
        low++;
        int temp = pivot;
        arr[end] = arr[low];
        arr[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        int[] dataSet = {1000, 10000, 1000000};
        Random random = new Random();
        for (int n : dataSet) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = random.nextInt(n * 10);
            }
            int target = data[random.nextInt(n)];

            long startTime;
            long endTime;

            //bubble Sort time
            startTime = System.nanoTime();
            bubbleSort(data);
            endTime = System.nanoTime();
            long bubbleSortTime = endTime - startTime;

            //mergesort time
            startTime = System.nanoTime();
            mergeSort(data, 0, n - 1);
            endTime = System.nanoTime();
            long mergeSortTime = endTime - startTime;

            //quicksort time
            startTime = System.nanoTime();
            quickSort(data, 0, n - 1);
            endTime = System.nanoTime();
            long quickSortTime = endTime - startTime;

            System.out.println("DataSet : " + n);
            System.out.println("Bubble Sort Time : " + bubbleSortTime / 1000000.0 + "m/s");
            System.out.println("Merge Sort Time : " + mergeSortTime / 1000000.0 + "m/s");
            System.out.println("Quick Sort Time : " + quickSortTime / 1000000.0 + "m/s");
            System.out.println();
        }
    }
}

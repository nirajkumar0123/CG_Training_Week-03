package binarysearch.firstandlastocc;

import java.util.Arrays;

public class FirstAndLastOccInSortedArray {
    //Method to find the firstOccurence of an element in an array
    static int firstOccurrenceInSortedArray(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    //Method to find last Occurrence of an element in array
    static int lastOccurrenceInSortedArray(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                if (mid == n - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    //Main method
    public static void main(String[] args) {
        int[] arr = {5, 10, 10, 15, 20, 20, 20};
        int target = 20;
        int[] result = new int[2];
        result[0] = firstOccurrenceInSortedArray(arr, target);
        result[1] = lastOccurrenceInSortedArray(arr, target);
        System.out.println(Arrays.toString(result));
    }
}

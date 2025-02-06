package challengeproblemsearching.binarysearchfortargetindex;

import java.util.Arrays;

public class BinarySearchTargetindex {
    public static int binarySearchForTargetIndex(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, -1, 2, 6, 9, 3, -4, 1};

        //target index
        int targetIndex = binarySearchForTargetIndex(arr, 2);
        System.out.println(targetIndex);
    }
}

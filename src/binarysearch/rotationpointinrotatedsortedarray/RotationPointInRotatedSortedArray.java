package binarysearch.rotationpointinrotatedsortedarray;

public class RotationPointInRotatedSortedArray {
    public static int rotatedSortedArrayRotationPoint(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int result = rotatedSortedArrayRotationPoint(arr);
        System.out.println(result);
    }
}

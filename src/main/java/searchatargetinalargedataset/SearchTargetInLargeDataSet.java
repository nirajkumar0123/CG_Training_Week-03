package searchatargetinalargedataset;

import java.util.Arrays;
import java.util.Random;

public class SearchTargetInLargeDataSet {
    //linear search
    static void linearSearch(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return;
            }
        }
    }

    //binary search
    static void binarySearch(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] dataset = {1000, 10000, 1000000};
        Random random = new Random();
        for (int n : dataset) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = random.nextInt(n * 10);
            }

            int target = data[random.nextInt(n)];

            //Measure time for linear search
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            long linearTime = endTime - startTime;

            //Measure time for binary search
            Arrays.sort(data);
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            long binary_time = endTime - startTime;

            System.out.println("DataSet : " + n);
            System.out.println("Linear Search Time : " + linearTime / 1000000.0 + "m/s");
            System.out.println("Binary Search Time : " + binary_time / 1000000.0 + "m/s");
            System.out.println();
        }
    }
}

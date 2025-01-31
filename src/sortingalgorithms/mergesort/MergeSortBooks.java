package sortingalgorithms.mergesort;

public class MergeSortBooks {
    public static void mergeSort(int[] prices, int left, int right){
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively divide the array
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge sorted halves
            merge(prices, left, mid, right);
        }
    }

    public static void merge(int[] prices, int left, int mid, int right){
        int n1 = mid - left + 1; //size of leftSubarray
        int n2 = right - mid;  //size of rightSubarray

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to left subarray
        for(int i = 0; i < n1; i++){
            leftArray[i] = prices[left + i];
        }

        // Copy data to right subarray
        for(int j = 0; j < n2; j++){
            rightArray[j] = prices[mid + 1 + j];
        }


        // Merge the two subarrays back into the original array
        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2){
            if(leftArray[i] <= rightArray[j]){
                prices[k++] = leftArray[i++];
            }
            else{
                prices[k++] = rightArray[j++];
            }
        }

        while(i < n1){
            prices[k++] = leftArray[i++];
        }

        while(j < n2){
            prices[k++] = rightArray[j++];
        }

    }

    public static void display(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] Prices = {350, 120, 500, 200, 750, 90, 300};
        System.out.println("Before Sorting: ");
        display(Prices);
        mergeSort(Prices, 0, Prices.length - 1);
        display(Prices);
    }
}

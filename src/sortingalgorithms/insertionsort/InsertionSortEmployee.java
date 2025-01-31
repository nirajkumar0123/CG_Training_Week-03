package sortingalgorithms.insertionsort;

public class InsertionSortEmployee {
    public static void insertionSort(int[] empId) {
        int n = empId.length;
        for (int i = 1; i < n; i++) {
           for(int j = i; j > 0 && empId[j-1]  > empId[j]; j--){
               int temp = empId[j];
               empId[j] = empId[j - 1];
               empId[j - 1] = temp;
           }
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
    int[] arr = {78, 92, 45, 89, 67, 55, 99, 81};
        System.out.println("Before Sorting: ");
        display(arr);
        insertionSort(arr);
        System.out.println("After Sorting: ");
        display(arr);
    }
}

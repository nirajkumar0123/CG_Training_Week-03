package sortingalgorithms.bubblesort;

public class BubbleSortMarks {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    swapped = true;
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    //Display method
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 2, 4, 1, 18, 0, -1};
        System.out.println("Before Sorting: ");
        display(arr);
        bubbleSort(arr);
        System.out.println("After Sorting: ");
        display(arr);
    }
}

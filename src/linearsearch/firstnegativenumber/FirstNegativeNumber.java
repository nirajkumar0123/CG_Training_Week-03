package linearsearch.firstnegativenumber;

public class FirstNegativeNumber {
    public static int searchFirstNegativeNum(int[] arr) {
        int n = arr.length;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int currElement = arr[i];
            if (currElement < 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 0, -1, 7, 89};
        int search = searchFirstNegativeNum(arr);
        System.out.println(search);
    }
}

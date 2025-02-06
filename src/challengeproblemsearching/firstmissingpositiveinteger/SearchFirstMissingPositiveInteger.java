package challengeproblemsearching.firstmissingpositiveinteger;

public class SearchFirstMissingPositiveInteger {
    public static int searchFirstMissingPositiveInteger(int[] arr) {
        int n = arr.length;
        boolean[] marked = new boolean[n + 1];
        for (int num : arr) {
            if (num > 0 && num <= n) {
                marked[num] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!marked[i]) {
                return i;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = {4, -1, 2, 6, 9, 3, -4, 1};
        //search missing number
        int result = searchFirstMissingPositiveInteger(arr);
        System.out.println(result);
    }
}

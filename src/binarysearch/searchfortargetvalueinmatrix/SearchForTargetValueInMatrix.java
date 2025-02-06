package binarysearch.searchfortargetvalueinmatrix;

public class SearchForTargetValueInMatrix {
    public static boolean searchForTargetValue(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int left = 0;
        int right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / m;
            int col = mid % m;

            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 5, 9},
                {14, 20, 21},
                {30, 34, 43}
        };
        int target = 21;
        System.out.println(searchForTargetValue(mat, target));
    }
}

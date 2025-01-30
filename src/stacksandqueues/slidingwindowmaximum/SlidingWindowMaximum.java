package stacksandqueues.slidingwindowmaximum;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    // Function to find maximum in each sliding window
    public static void slidingWindowMax(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }

        // Deque to store indices of potential max elements in the window
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;

        // Result array to store the maximum for each window
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            // Remove elements from the deque which are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove all elements smaller than the current element from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current element's index to the deque
            deque.offerLast(i);

            // Once we reach the size of the window, start adding results
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        // Print the result array containing the maximums of all windows
        System.out.println("Sliding Window Maximums:");
        for (int max : result) {
            System.out.print(max + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        slidingWindowMax(nums, k);
    }
}



package hashmapsandhashfunctions.twosumproblem;

import java.util.HashMap;

public class TwoSumProblem {
    public static int[] twoSumProblem(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
          int complement = target - arr[i];
          if(map.containsKey(complement)){
              int start = map.get(complement);
              int end = i;

              return new int[]{start, end};
          }
            map.put(arr[i], i);
        }
        return new int[]{}; // if no pair found return an empty array
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 14;
        int[] result = twoSumProblem(nums, target);

        if (result.length == 0) {
            System.out.println("No two sum solution.");
        } else {
            System.out.println("Indices of the numbers that add up to the target: " + result[0] + ", " + result[1]);
        }
    }
}

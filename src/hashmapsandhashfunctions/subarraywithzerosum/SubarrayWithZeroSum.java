package hashmapsandhashfunctions.subarraywithzerosum;

import java.util.HashMap;

public class SubarrayWithZeroSum {
    public static void subarrayWithZeroSum(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(0, -1);
        int n = arr.length;

        for(int i = 0; i < n; i++){
            preSum += arr[i];

            if(map.containsKey(preSum)){
                int start = map.get(preSum) + 1;
                int end = i;

                System.out.println("Subarray with zero sum found from index " + start + " to " + end);

                for(int j = start; j <= end; j++){
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
                return;
            }
            map.put(preSum, i);
        }
        System.out.println("Subarray with zeroSum not found!");
    }
    public static void main(String[] args) {
        int[] arr = {10, 2, 30, -20, -10, 20};
        int n = arr.length;
        subarrayWithZeroSum(arr);
    }
}

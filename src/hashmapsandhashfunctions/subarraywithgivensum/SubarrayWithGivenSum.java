package hashmapsandhashfunctions.subarraywithgivensum;

import java.util.HashMap;

public class SubarrayWithGivenSum {
    public static void pairWithGivenSum(int[] arr, int givenSum){
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        int n = arr.length;
        map.put(0, -1);

        for(int i = 0; i < n; i++){
            preSum += arr[i];

            if(map.containsKey(preSum - givenSum)){
                int start = map.get(preSum - givenSum) + 1;
                int end = i;

                System.out.println("Pair found with Given Sum found from index " + start + " to " + end);
                for(int j = start; j <=end; j++){
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
                return;
            }
            map.put(preSum, i);
        }
        System.out.println("No Pair Found!");
    }
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 13};
        int n = arr.length;
        int givenSum = 13;
        pairWithGivenSum(arr, givenSum);
    }
}

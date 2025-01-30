package hashmapsandhashfunctions.longestconsecutivesequence;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : arr){
            set.add(x);
        }

        int res = 1;
        for(Integer x : set){
            if(!set.contains(x-1)){
                int curr = 1;
                while(set.contains(x + curr)){
                    curr++;
                }
                res = Math.max(curr, res);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 7, 3, 2, 5, 6};
        int count = longestConsecutiveSequence(arr);
        System.out.println("count of longestsequence is: " + count);
    }
}

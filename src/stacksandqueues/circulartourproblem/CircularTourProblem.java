package stacksandqueues.circulartourproblem;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTourProblem {

    public static int findStartingPoint(int[] petrol, int[] distance){
        int tank = 0;
        int totalSurplus = 0;
        int start = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < petrol.length; i++){
            int currentSurplus = petrol[i] - distance[i];
            tank += currentSurplus;
            totalSurplus += currentSurplus;

            // Add the current pump index to the queue
            queue.offer(i);

            // If tank goes negative, reset start to the next pump
            if(tank < 0){
                // Dequeue the current pump as we reset
                queue.poll();
                start = i + 1;
                tank = 0; //reset tank
            }
        }
        if(totalSurplus >= 0){
            return start;
        }
        return -1;
    }
    public static void main(String[] args) {
       int[] petrol = {4, 6, 7, 4};
       int[] distance = {6, 5, 3, 5};

       int start = findStartingPoint(petrol, distance);

       if(start == -1) {
           System.out.println("Not Possible to complete the circular tour!");
       }else{
           System.out.println("Starting index is: "+start);
       }
    }
}

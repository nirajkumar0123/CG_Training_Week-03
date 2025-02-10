package comparingdifferentdatastructuresforsearching;

import java.util.*;

public class DataStructureSearchComparison {

    // Function to perform linear search in an array
    static double searchInArray(int[] array, int key) {
        long startTime = System.nanoTime();
        for (int num : array) {
            if (num == key) break;
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
    }

    // Function to search in HashSet (O(1))
    static double searchInHashSet(HashSet<Integer> hashSet, int key) {
        long startTime = System.nanoTime();
        boolean found = hashSet.contains(key);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000.0;
    }

    // Function to search in TreeSet (O(log N))
    static double searchInTreeSet(TreeSet<Integer> treeSet, int key) {
        long startTime = System.nanoTime();
        boolean found = treeSet.contains(key);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000.0;
    }


    public static void main(String[] args) {
        int[] sizes = {1_000, 100_000, 1_000_000}; // Different dataset sizes

        for (int size : sizes) {
            System.out.println("Testing with dataset size: " + size);

            // Generate dataset
            Random rand = new Random();
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int num = rand.nextInt(size * 10);
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            int searchKey = array[rand.nextInt(size)];

            // Perform searches using separate functions
            double arrayTime = searchInArray(array, searchKey);
            double hashSetTime = searchInHashSet(hashSet, searchKey);
            double treeSetTime = searchInTreeSet(treeSet, searchKey);

            // Display results
            System.out.println("Array Search Time: " + arrayTime + " ms");
            System.out.println("HashSet Search Time: " + hashSetTime + " ms");
            System.out.println("TreeSet Search Time: " + treeSetTime + " ms");
            System.out.println();
        }
    }
}

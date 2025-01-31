package sortingalgorithms.countingsort;

public class CountingSortAges {
    public static void countingSort(int[] ages) {
        int maxAge = 18;
        int minAge = 10;

        int[] count = new int[maxAge - minAge + 1];

        for (int i = 0; i < ages.length; i++) {
            count[ages[i] - minAge]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ages[index++] = i + minAge;
                count[i]--;
            }
        }
    }

    public static void display(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] studentAges = {15, 18, 12, 14, 17, 10, 16, 13, 15, 18, 11};

        System.out.println("Before Sorting: ");
        display(studentAges);

        countingSort(studentAges);

        System.out.println("After Sorting: ");
        display(studentAges);
    }
}

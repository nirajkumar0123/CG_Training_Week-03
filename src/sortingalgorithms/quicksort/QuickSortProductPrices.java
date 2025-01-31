package sortingalgorithms.quicksort;

public class QuickSortProductPrices {
    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }


    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    public static void display(int[] prices) {
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] productPrices = {350, 120, 500, 200, 750, 90, 300};
        System.out.println("Before Sorting: ");
        display(productPrices);

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("After Sorting: ");
        display(productPrices);
    }
}

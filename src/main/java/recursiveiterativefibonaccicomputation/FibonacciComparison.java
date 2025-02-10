package recursiveiterativefibonaccicomputation;

public class FibonacciComparison {
    // Recursive Fibonacci
    static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci
    static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};
        for (int n : testValues) {

            long startTime = System.currentTimeMillis();
            fibonacciRecursive(n);
            long endTime = System.currentTimeMillis();
            System.out.println("Recursive Time: " + (endTime - startTime) + " ms");


            startTime = System.currentTimeMillis();
            fibonacciIterative(n);
            endTime = System.currentTimeMillis();
            System.out.println("Iterative Time: " + (endTime - startTime) + " ms");

        }
    }
}

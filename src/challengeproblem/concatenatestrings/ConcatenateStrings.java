package challengeproblem.concatenatestrings;

public class ConcatenateStrings {
    private static final int ITERATIONS = 1_000_000;

    public static void compareStringBuffer() {
        StringBuffer buffer = new StringBuffer();
        long startTime = System.nanoTime();//start time

        for (int i = 0; i < ITERATIONS; i++) {
            buffer.append("hello");
        }
        long endTime = System.nanoTime();//start time
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void compareStringBuilder() {
        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();//start time

        for (int i = 0; i < ITERATIONS; i++) {
            sb.append("hello");
        }
        long endTime = System.nanoTime();//start time
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void main(String[] args) {
        compareStringBuffer();
        compareStringBuilder();
    }
}

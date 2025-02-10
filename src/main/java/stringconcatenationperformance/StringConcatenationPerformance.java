package stringconcatenationperformance;

public class StringConcatenationPerformance {

    //Using String
    static void stringConcat(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "hello";
        }
    }

    //Using StringBuffer
    static void stringBufferConcat(int n) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            buffer.append("hello");
        }
    }

    //Using StringBuilder
    static void stringBuilderConcat(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
    }

    public static void main(String[] args) {
        int[] dataset = {1000, 10000, 1000000};
        for (int n : dataset) {

            long startTime;
            long endTime;
            //String  time taken
            startTime = System.nanoTime();
            stringConcat(n);
            endTime = System.nanoTime();
            long string_time = endTime - startTime;

            //StringBuffer time taken
            startTime = System.nanoTime();
            stringBufferConcat(n);
            endTime = System.nanoTime();
            long buffer_time = endTime - startTime;

            //StringBuilder time taken
            startTime = System.nanoTime();
            stringBuilderConcat(n);
            endTime = System.nanoTime();
            long builder_time = endTime - startTime;

            System.out.println("DataSet : " + n);
            System.out.println("String time taken : " + string_time / 1000000.0 + "m/s");
            System.out.println("StringBuffer time taken : " + buffer_time / 1000000.0 + "m/s");
            System.out.println("StringBuilder time taken : " + builder_time / 1000000.0 + "m/s");
            System.out.println();
        }
    }
}

package stringbuilder.reversestring;

public class ReverseString {
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "hello";
        String reversed = reverseString(str);
        System.out.println("Reversed String is: " + reversed);
    }
}

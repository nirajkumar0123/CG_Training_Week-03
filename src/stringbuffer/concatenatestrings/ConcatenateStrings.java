package stringbuffer.concatenatestrings;

public class ConcatenateStrings {
    public static String concatenateStrings(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        for (String word : words) {
            buffer.append(word).append(" ");
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        String[] str = {"Hello", "how", "are", "you!"};
        String concatenatedString = concatenateStrings(str);
        System.out.println("Concatenated String: " + concatenatedString);
    }
}

package stringbuilder.removeduplicatesfromstring;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesFromString {
    public static String removeDuplicateCharacters(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String str = input.nextLine();
        input.close();
        String removedduplicate = removeDuplicateCharacters(str);
        System.out.println("String after removing duplicates is: " + removedduplicate
        );
    }
}

package linearsearch.specificwordinsentences;

public class SearchSpecificWordInSentences {
    public static String searchForSpecificWord(String[] str, String word) {
        for (String sentence : str) {
            for(String a : sentence.split(" ")){
                if(a.equals(word)){
                    return sentence;
                }
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentence = {"Hello Ji kaise", "Ji mai badhiya", "Aur ji aap sunao!"};
        String word = "aap";
        String result = searchForSpecificWord(sentence, word);
        System.out.println(result);
    }
}

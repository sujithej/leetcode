import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sujith.j on 10/04/16.
 */
public class SubStringConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return new ArrayList<Integer>();
        //populate hash map of words
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }

        }
        int length =0;
        String str;
        List<Integer> ans  = new ArrayList<>();
        int startIndex =0;

        int wordLength = words[0].length();
        for (int i = 0; i < wordLength; i++) {
            startIndex = i;
            length =0;
            HashMap<String,Integer> currentCount = new HashMap<>();
            for (int j = i; j <= s.length() - wordLength; j = j+wordLength){
                str = s.substring(j,j+wordLength);
                if(wordCount.containsKey(str)){
                    if(currentCount.containsKey(str)){
                        currentCount.put(str,currentCount.get(str)+1);
                    }else{
                        currentCount.put(str,1);
                    }
                    length += 1;
                    while(currentCount.get(str) > wordCount.get(str)){
                        String deleteString = s.substring(startIndex,startIndex+wordLength);
                        currentCount.put(deleteString,currentCount.get(deleteString) - 1 );
                        startIndex = startIndex+wordLength;
                        length --;
                    }
                    if(length == words.length){
                        ans.add(startIndex);
                        String deleteString = s.substring(startIndex,startIndex+wordLength);
                        currentCount.put(deleteString,currentCount.get(deleteString) - 1 );
                        startIndex = startIndex+wordLength;
                        length --;
                    }
                }else{
                    length = 0;
                    startIndex = j+wordLength;
                    currentCount = new HashMap<>();
                }
            }
        }
        return ans;
    }

    public static void main(String []args){
        String []words = {"aa","aa"};
        List<Integer> ans  = (new SubStringConcatenation()).findSubstring("aaa",words);
        System.out.println("hold");

    }
}

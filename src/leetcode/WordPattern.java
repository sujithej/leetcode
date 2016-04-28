import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String []wordArray = str.split(" ");
        String []words = new String[26];
        HashSet<String> taken = new HashSet<>();
        if(wordArray.length != pattern.length())
            return false;

        int index;
        for(int i = 0; i  < pattern.length() ; i++) {
            index  = pattern.charAt(i) - 'a';
            if(words[index] == null) {
                if(taken.contains(wordArray[i])){
                    return false;
                }
                words[index] = wordArray[i];
                taken.add(wordArray[i]);
            } else if(!words[index].equals(wordArray[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []args) {
        System.out.println((new WordPattern()).wordPattern("abbc", "dog cat cat fish" ));
    }
}

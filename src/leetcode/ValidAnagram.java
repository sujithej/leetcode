import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            sCounts[s.charAt(i) - 'a']++;
            tCounts[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(sCounts[i] != tCounts[i])
                return false;
        }
        return true;
    }
}

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sujith.j on 27/04/16.
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        if(s == null)
            return s;
        ArrayList<Integer> vowelPostions = new ArrayList<>();
        for(int i = 0; i < s.length();i ++) {
            char c = s.charAt(i);
            //todo change it to hash set
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowelPostions.add(i);
            }
        }

        char []charArray  = s.toCharArray();
        int forwardPosition = 0;
        int reversePosition = vowelPostions.size() - 1;

        while(forwardPosition < reversePosition) {
            char c = charArray[vowelPostions.get(forwardPosition)];
            charArray[vowelPostions.get(forwardPosition)] = charArray[vowelPostions.get(reversePosition)];
            charArray[vowelPostions.get(reversePosition)] = c;
            forwardPosition ++;
            reversePosition --;
        }
        return String.valueOf(charArray);
    }


    public static void main(String []args) {
        String s = (new ReverseVowels()).reverseVowels("hello");
        System.out.println(s);
    }
}

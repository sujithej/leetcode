import sun.org.mozilla.javascript.internal.regexp.SubString;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int length = s.length();
        String temp;
        if (s == null || s.length() <= 1)
            return s;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            if(scanForPalindrome(s,i,i+1)){
                temp  = s.substring(2*(i+1));
                return reverseString(temp) + s;
            }
            if(scanForPalindrome(s,i,i)){
                temp  = s.substring(2*i+1,length);
                return reverseString(temp) + s;

            }

        }

        return null;
    }

    String reverseString(String str) {
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }

    public boolean scanForPalindrome(String s, int startLeft, int startRight) {
        while(startLeft >=0  ){
            if(startRight >= s.length())
                return false;
            if(s.charAt(startLeft) != s.charAt(startRight))
                return false;
            else{
                startLeft--;
                startRight++;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        String s = "abb";
        String ans = (new ShortestPalindrome()).shortestPalindrome(s);
        System.out.println(ans);

    }
}

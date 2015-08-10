package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 10/07/15
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class CountAndSay {
    public static void main(String[] args) {
        String ans = (new CountAndSay()).countAndSay(5);
        System.out.println(ans);


    }

    public String countAndSay(int n) {
        if(n==0)
            return "";

        String temp = "1";
        String ans="1";
        char tempChar;
        int count = 0;
        int start = 0;
        int end = 0;
        for (int i = 1; i < n; i++) {
            ans = "";
            count = 0;
            start = 0;
            tempChar = temp.charAt(start);
            for (end = 0; end < temp.length(); end++) {
                if (tempChar == temp.charAt(end))
                {
                    count++;
                }
                else
                {
                    ans = ans+ String.valueOf(count)+tempChar;
                    start = end;
                    tempChar = temp.charAt(start);
                    count = 1;
                }

            }
            ans = ans+String.valueOf(count)+tempChar;
            temp = ans;
//            System.out.println(ans);
        }
        return ans;

    }

}

package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 12/06/15
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestPalindrome {

    public static void main(String[] args) throws Exception {
        System.out.println((new LongestPalindrome()).longestPalindrome("bbbb"));
    }

    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int startindex = 0;
        int endindex = 0;
        int globalmax = 0;
        int j;


        for (int i = 0; i < s.length(); i++) {
            j = 0;


            while (i - j >= 0 && i + j < s.length() && (charArray[i - j] == charArray[i + j])) {
                j++;
            }

            if (globalmax < 2 * (j - 1) + 1) {
                globalmax = 2 * j - 1;
                startindex = i - (j - 1);
                endindex = i + (j - 1);
            }

            System.out.println("i started" + i);
            j = 0;
            while (i - j >= 0 && i + 1 + j < s.length() && (charArray[i - j] == charArray[i + 1 + j])) {
                j++;
            }
            System.out.println(j);
            if (globalmax < 2 * (j - 1) + 2) {
                System.out.println(j);
                globalmax = 2 * j;
                System.out.println(j);
                startindex = i - (j - 1);
                System.out.println(j + "i :" + i);
                endindex = i + 1 + (j - 1);
                System.out.println(startindex + " " + endindex);

            }


        }


        return s.substring(startindex, endindex + 1);
    }
}

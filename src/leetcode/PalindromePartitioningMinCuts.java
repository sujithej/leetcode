import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujith.j on 08/04/16.
 */
public class PalindromePartitioningMinCuts {
    public int minCut(String s) {
        ArrayList<List<Integer>> palindromes = new ArrayList<List<Integer>>(s.length());
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        boolean [][]dp = new boolean[length][length];
        int[] shortest = new int[length+1];
        List<Integer> temp;
        for (int i = 0; i < length; i++) {
            temp = new ArrayList<Integer>();
            for (int j = i; j < length; j++) {
                if (isPalindrome(charArray, i, j,dp)) {
                    temp.add(j);
                }
            }
            palindromes.add(temp);
            shortest[i] = Integer.MAX_VALUE;
        }
        shortest[0] = 0;
        for (int i = 0; i < length; i++) {
            temp = palindromes.get(i);
            for (Integer end : temp) {
                shortest[end+1] = Math.min(shortest[end+1],shortest[i]+1);
            }
        }


        return shortest[length-1];
    }

    public Boolean isPalindrome(char[] charArray, int i, int j,boolean [][]dp) {
        if(charArray[i] == charArray[j] && ((j - i) <= 1 || dp[i+1][j-1])){
            dp[i][j] = true;
            return true;
        }
//        for (int index = i; index <= i + (j - i) / 2; index++) {
//            if (charArray[index] != charArray[j + i - (index)])
//                return false;
//        }
        return true;
    }


}

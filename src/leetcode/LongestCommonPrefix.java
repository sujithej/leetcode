package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 28/06/15
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int endIndex = Integer.MAX_VALUE;
        for(String str:strs)
        {
            if(str.length() < endIndex)
                endIndex = str.length();

        }

        char []charArray = new char[endIndex];
        int i =0;
        boolean flag = true;
        char temp;
        while(flag)
        {
            temp = strs[0].charAt(i);
            for(String str:strs)
            {
                if(str.charAt(i) != temp)
                    flag = false;
            }
            if(flag)
            {
                charArray[i++] = temp;
            }

        }
        String ans = new String(charArray);
        return ans.trim();



    }
}

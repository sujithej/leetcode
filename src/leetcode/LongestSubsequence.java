package leetcode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 11/06/15
 * Time: 9:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongestSubsequence {

    public static void main(String []args)
    {
        int  solution = lengthOfLongestSubstring("aa");
      //                                          12345678901
    }


    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap= new HashMap<Character,Integer>();
        char []charArray = s.toCharArray();
        int globalMaximum =0,localMaximum =0;
        int startIndex = 0;

        for(int i =0 ;i< s.length() ; i++)
        {
            System.out.println("i:" + i);
            localMaximum++;
            System.out.println(localMaximum);
            System.out.println(globalMaximum);
            if(hashMap.containsKey(charArray[i]))
            {

                int index = hashMap.get(charArray[i]);
                if(localMaximum -1 > globalMaximum)
                    globalMaximum = localMaximum -1;
                localMaximum = (i-index);
                System.out.println("starting removal");

                for(int j=startIndex ; j< index ;j++)
                {
                    System.out.println(charArray[j]);
                    hashMap.remove(charArray[j]);

                }

                startIndex = index +1;
            }
            hashMap.put(charArray[i], i);
            System.out.println("iended");


        }
        System.out.println(localMaximum);
        System.out.println(globalMaximum);
        if(localMaximum  > globalMaximum)
            globalMaximum = localMaximum;

        System.out.println(globalMaximum);


        return globalMaximum;
    }
}

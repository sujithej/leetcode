package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 05/07/15
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindRepeatedDnaSequences {

    public static void main(String []args)
    {
        List<String> ans = (new FindRepeatedDnaSequences()).findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(Integer.toBinaryString((1 << 20) - 1));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put('A',0);
        hashMap.put('C',1);
        hashMap.put('G',2);
        hashMap.put('T',3);
        HashSet<Integer> duplicates = new HashSet<Integer>();
        List<String> ans = new ArrayList<String>();
        Set<Integer> added = new HashSet<Integer>();
        int temp = 0;

        if(s.length() < 10)
            return ans;

        for(int i=0 ; i < 10;i++)
        {
            temp = (temp<<2) + hashMap.get(s.charAt(i));
//            System.out.println(i);
//            System.out.println(Integer.toBinaryString(temp));
        }

        duplicates.add(temp);
        int truncate  = (1 << 20) - 1;

        for(int i= 10;i<s.length();i++)
        {
            temp = ((temp << 2) + hashMap.get(s.charAt(i))) & truncate;
//            System.out.println(i);
//            System.out.println(Integer.toBinaryString(temp));
            if(duplicates.contains(temp) && !added.contains(temp))
            {
                ans.add(s.substring(i - 9, i + 1));
                added.add(temp);
            }
            else
            {
                duplicates.add(temp);
            }
        }
        return ans;

    }


}

package leetcode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 05/07/15
 * Time: 12:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class IsIsomorphic {

    public static void main(String []args)
    {
        boolean flag = (new IsIsomorphic()).isIsomorphic("ab","aa");
        System.out.println(flag);
    }

    public boolean isIsomorphic(String s, String t) {

        return isIsomorphicUtil(s,t) && isIsomorphicUtil(t,s);
    }

    public boolean isIsomorphicUtil(String s,String t)
    {    if(s.length() != t.length())
        return false;
        HashMap<Character,Character> hashMap = new HashMap<Character, Character>();
        Character temp;
        for(int i=0;i< s.length();i++)
        {
            temp = hashMap.get(s.charAt(i));
            if(temp == null)
            {
                hashMap.put(s.charAt(i),t.charAt(i));
            }
            else if(temp != t.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

}

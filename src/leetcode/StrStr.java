package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 02/07/15
 * Time: 8:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class StrStr {

    public static void main(String []args)
    {
        int index = (new StrStr()).strStr("aaa","aaa");
        System.out.println(index);
    }


    public int strStr(String haystack, String needle) {
        int start =0,end =0;

        int ans =-1;
        if(needle.length() ==0 )
            return 0;
        if(needle.length() ==0 || haystack.length() ==0)
            return -1;
        boolean flag = false;
        if(needle.length() ==0 || haystack.length() ==0)
            return -1;

        for(int i=0;i<haystack.length();i++)
        {
            if(haystack.charAt(i) == needle.charAt(0))
            {
                start = i;
                for(end =i;end < i+needle.length();end++)
                {
                    if(end == haystack.length() || haystack.charAt(end) != needle.charAt(end-i)   )
                        break;

                }
                if(end ==  i+needle.length())
                {
                    flag = true;
                    ans =start;
                }
            }

        }
        if(flag)
            return ans;
        else
            return -1;



    }

}

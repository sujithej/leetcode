package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 11/07/15
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        String s = Integer.toBinaryString(n);
        if(n <= 0)
            return false;
        int count =0;
        for(int i =0; i<s.length();i++)
        {
            if(s.charAt(i) == '1')
            {
                count++;
                if(count > 1)
                    return false;
            }
        }

        if(count ==1)
            return true;
        return false;

    }
}

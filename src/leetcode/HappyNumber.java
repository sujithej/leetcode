package leetcode;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 12/07/15
 * Time: 12:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class HappyNumber {
    public boolean isHappy(int n)
    {
        int sum = 0;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(n);
        while(n != 1 )
        {
            hashSet.add(n);
            n = getNextSequence(n);
            if(hashSet.contains(n))
                return false;
        }
        return true;
    }

    public int getNextSequence(int n)
    {
        int sum =0;
        int temp;
        while(n != 0)
        {
            temp = n%10;
            sum = sum + temp*temp;
            n = n/10;
        }
        return sum;
    }
}

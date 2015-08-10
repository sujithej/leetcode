package leetcode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 18/06/15
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int num:nums)
        {
            if(hashMap.containsKey(num))
                return true;
            hashMap.put(num,num);
        }

        return false;


    }
}

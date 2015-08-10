package leetcode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 27/06/15
 * Time: 8:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        Integer count;
        int counthald = nums.length/2;
        for(int i:nums)
        {
            count = hashMap.get(i);
            if(count == null)
            {
                count =0;
            }

            hashMap.put(i,count+1);
            if(count +1 > counthald)
                return i;


        }

        return -1;
    }
}

package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 23/06/15
 * Time: 12:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaxSubArray {
    public static void main(String []args)
    {
        int []nums = {1};
        int a  = (new MaxSubArray()).maxSubArray(nums);
    }

    public int maxSubArray(int[] nums) {
        int global = nums[0],localMax = 0;
        for(int i:nums)
        {
            localMax += i;
            if(localMax > global)
                global = localMax;
            if(localMax < 0)
                localMax = 0;
        }





     return global;
    }
}

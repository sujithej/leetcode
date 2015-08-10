package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 05/07/15
 * Time: 12:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class rob {

    public int rob(int[] nums) {
       int []cost = new int[nums.length];

        if(nums.length ==0)
            return 0;
        if(nums.length ==1)
            return cost[0];
       cost[0] = nums[0];
       cost[1] = Math.max(cost[0],nums[1]);
        for(int i=2 ;i< nums.length;i++)
        {
            cost[i] = Math.max(cost[i-2]+nums[i],cost[i-1]);

        }
        return cost[nums.length-1];
    }
}

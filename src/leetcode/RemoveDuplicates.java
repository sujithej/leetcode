package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 01/07/15
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicates {
    public static void main(String []args)
    {
        int []nums = {1,1,2};
        int count = (new RemoveDuplicates()).removeDuplicates(nums);
        System.out.println("hold" + count);

    }
    public int removeDuplicates(int[] nums) {
        if(nums.length <2)
            return nums.length;

        int start=1,end=1;
        for(end =1;end < nums.length;end++)
        {
            if(nums[end] == nums[end-1])
            {
                continue;
            }
            else
            {
               nums[start] = nums[end];
               start++;
            }
        }


        return start;
    }
}

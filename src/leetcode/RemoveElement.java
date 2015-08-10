package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 02/07/15
 * Time: 8:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int start=0,end=0;
        for(end =0;end < nums.length;end++)
        {
            if(nums[end] == val)
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

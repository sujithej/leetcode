package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 05/07/15
 * Time: 1:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchInsert {
    public static void main(String []args)
    {

    }
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0])
            return 0;
        int start = 0;
        int end = nums.length -1;
        int mid;
        while(start <=  end)
        {
            mid = getMid(start,end);
            if(nums[mid] == target )
                return mid;
            if(target < nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return start+1;


    }

    public int getMid(int start,int end)
    {
        return (start+end)/2;
    }
}

package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 04/07/15
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchRange {

    public static void main(String []args)
    {
        int [] nums = {5, 7, 7, 8, 8, 10};
        int []ans = (new SearchRange()).searchRange(nums,12);
        System.out.println("hold");

    }

    public int[] searchRange(int[] nums, int target) {
        int []ans = new int[2];
        ans[0]  = binarySearch(nums,target,true);
        ans[1]  = binarySearch(nums,target,false);
        return ans;

    }

    public int binarySearch(int []nums,int target,boolean smallestIndex)
    {
        int start =0,end =nums.length -1;
        int mid;
        while(start <= end)
        {
            mid = getMid(start,end);
            if(nums[mid] == target)
            {
                if(smallestIndex && checkSmallestIndex(nums,mid))
                {
                    return mid;
                }
                if(!smallestIndex && checkLargestIndex(nums,mid))
                {
                    return mid;
                }


            }

            if(nums[mid] > target || (nums[mid] == target && smallestIndex))
                end = mid-1;
            else
                start =mid+1;
        }
        return -1;

    }

    public int getMid(int start,int end)
    {
        return (start+end)/2;
    }

    public boolean checkSmallestIndex(int []nums,int index)
    {
        if(index == 0)
            return true;
        else
        {
            if(nums[index-1]  < nums[index])
                return true;
            else
                return false;

        }
    }

    public boolean checkLargestIndex(int []nums,int index)
    {
        if(index == nums.length-1)
            return true;
        else
        {
            if(nums[index]<nums[index+1])
                return true;
            else
                return false;
        }
    }


}


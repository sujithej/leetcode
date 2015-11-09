/**
 * Created by sujith.j on 03/11/15.
 */
public class SearchRotatedSortedArray2 {

    public static void main(String []args)
    {
        int []nums = {3,1};
        (new SearchRotatedSortedArray2()).search(nums,1);
    }

    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int start = 0;
        int end = nums.length - 1;
        int mid= 0;
        int midAdjusted = 0;
        int length = nums.length;
        while(start <= end)
        {
            mid = start+(end-start)/2;
            midAdjusted = adjustInices(mid,length,pivot);
            if(nums[midAdjusted] == target)
                return true;
            if(nums[midAdjusted] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;

    }

    private int getMid(int pivot, int start, int end, int length) {
        return adjustInices(start +(end-start)/2,length,pivot);
    }

    private int adjustInices(int index,int length,int pivot)
    {
        if( pivot >= Integer.MAX_VALUE - length )
            return (int)(((long)index + (long)pivot )% length);
        else
            return (index+pivot)%length;
    }


    public int findPivot(int []nums)
    {
        int start = 0;
        int end = nums.length - 1;
        int mid= 0;
        if(nums.length <=1)
            return 0;
        while(start <= end)
        {
            mid = start+(end-start)/2;
            if(mid == 0 && nums[mid] < nums[mid+1] )
                return mid;
            if(mid != 0 && nums[mid] < nums[mid-1])
                return mid;
            if(nums[mid] < nums[start])
                end = mid-1;
            else if(nums[mid] > nums[start]){
                start = mid + 1;
                if (start < nums.length && nums[start] < nums[start - 1])
                    return start;
            }
            else
            {
                start++;
            }

        }
        return 0;
    }
}

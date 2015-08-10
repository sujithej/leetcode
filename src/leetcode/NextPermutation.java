package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 19/07/15
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class NextPermutation {
    public static void main(String []args)
    {
        int []nums = {1,1,3};
        (new NextPermutation()).nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        (new NextPermutation()).nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        (new NextPermutation()).nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        (new NextPermutation()).nextPermutation(nums);
        System.out.println(Arrays.toString(nums));


    }

    public void nextPermutation(int []nums)
    {
        int nextindex;
        for(int i = nums.length -1; i >=0; i-- )
        {
            nextindex  = findNextSmallestIndex(nums,nums[i],i);
            if(nextindex != i)
            {
                swap(nums,nextindex,i);
                return;
            }

        }
        Arrays.sort(nums);




    }

    public int findNextSmallestIndex(int []nums,int target,int end)
    {
        int smallest = -1;
        int nextsmallest = end;
        for(int i=0;i<end;i++)
        {
            if(nums[i] < target && nums[i] >= smallest)
            {
                smallest = nums[i];
                nextsmallest = i;
            }
        }
        return nextsmallest;
    }




    public int binarySearch(int []nums,int target,int start, int end)
    {
        int mid;
        while(start<end)
        {
            mid = start + (end-start)/2;
            if(target == nums[start])
            if(target < nums[start])
                end = mid -1;
            else
                start = mid+1;
        }
        return -1;
    }



    public void swap(int []nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


/**
 * Created by sujith.j on 05/11/15.
 */
public class MinSubArrayLen {
    public static void main(String []args)
    {
        int []nums = {2,3,1,2,4,3};
        int n = (new MinSubArrayLen()).minSubArrayLen(7,nums);
        System.out.println(n);

    }


    public int minSubArrayLen(int s, int[] nums) {
        int []minSubArray = new int [nums.length];
        int start = 0;
        int end =0;
        int length = nums.length;
        int sum = 0;
        while(end < length && start < length)
        {
            if(sum >= s)
                minSubArray[end-1] = end-start;
            if(sum < s)
            {
                sum += nums[end++];
            }
            else
            {
                sum -= nums[start++];
            }

        }

        while(sum >= s)
        {
            minSubArray[end-1] = end-start;
            sum -= nums[start++];

        }


        int min = Integer.MAX_VALUE;
        boolean minExists = false;
        for (int i : minSubArray) {
            if(i >= 1 && i < min ) {
                min = i;
                minExists = true;
            }

        }
        if(minExists)
            return min;
        else
            return 0;

    }
}

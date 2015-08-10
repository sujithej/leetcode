package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 30/06/15
 * Time: 8:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSumClosest {
    public static void main(String []args)
    {
        int []s =  {1,1,-1,-1,3};
        Date date = new Date();
        System.out.println(date.getTime());
        int sum = (new ThreeSumClosest()).threeSumClosest(s,-1);
        date = new Date();
        System.out.println(date.getTime());
        System.out.println(sum);
        int temp;



    }

    public int threeSumClosest(int[] nums,int target) {
//        List<List<Integer>> ans = new ArrayList<List<Integer>>() ;
//        HashSet<ArrayList<Integer>> unique = new HashSet<ArrayList<Integer>>();
        Arrays.sort(nums);

        int start,end,temp,closestSum = Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE;
        int localclosest ;
        for(int i =0;i<nums.length;i++ )
        {

            if(i == 0 || nums[i] > nums[i-1])
            {
                start = i+1;
                end = nums.length -1 ;
                while(start < end)
                {
                    if(nums[start] + nums[end] + nums[i] == target )
                    {
                        return target;
                    }
                    temp = nums[start] + nums[end] + nums[i];
                    if(temp < target)
                    {
                        localclosest =  target - temp;
                        if(localclosest < closest )
                        {
                            closest = localclosest;
                            closestSum = temp;
                        }
                        start++;
                    }
                    else
                    {
                        localclosest = temp - target;
                        if(localclosest < closest )
                        {
                            closest = localclosest;
                            closestSum = temp;
                        }


                        end --;
                    }



                }

            }

        }

        return closestSum;

    }

}

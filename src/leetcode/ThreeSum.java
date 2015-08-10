package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 29/06/15
 * Time: 10:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSum {

    public static void main(String []args)
    {
        int []s =  {0,0,0,1};
        Date date = new Date();
        System.out.println(date.getTime());
        List<List<Integer>>ans = (new ThreeSum()).threeSum(s);
        date = new Date();
        System.out.println(date.getTime());
        System.out.println("dgg");



    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>() ;
        HashSet<ArrayList<Integer>> unique = new HashSet<ArrayList<Integer>>();
        Arrays.sort(nums);
        ArrayList<Integer> temp;
        int start,end;
        for(int i =0;i<nums.length;i++ )
        {

            if(i == 0 || nums[i] > nums[i-1])
            {
                start = i+1;
                end = nums.length -1 ;
                while(start < end)
                {
                    if(nums[start] + nums[end] + nums[i] == 0 )
                    {
                        temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        if(!unique.contains(temp))
                        {
                            unique.add(temp);
                            ans.add(temp);
                        }
                    }
                    if(nums[start] + nums[end] + nums[i] < 0)
                    {
                        start++;
                    }
                    else
                        end --;


                }

            }

        }
        return ans;

    }


    class Point
    {
        int index,val;
        Point(int index,int val)
        {
            this.index = index;
            this.val = val;
        }
    }

}

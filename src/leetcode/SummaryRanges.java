package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 04/07/15
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class SummaryRanges {
    public static void main(String args[])
    {
        int []nums  = {0,1,2,4,5,7};
        List<String> ans = (new SummaryRanges()).summaryRanges(nums);
        System.out.println("hold");

    }
    public List<String> summaryRanges(int[] nums) {

        int start =0,end =0;
        List<String> ans  = new ArrayList<String>();
        if(nums.length == 0)
            return ans;
        for(;end < nums.length-1;end++)
        {
            if(nums[end]+1 != nums[end+1] )
            {
                if(start != end)
                    ans.add(nums[start]+"->"+nums[end]);
                else
                    ans.add(String.valueOf(nums[start]));
                start = end+1;
            }

        }
        if(start != end)
            ans.add(nums[start]+"->"+nums[end]);
        else
            ans.add(String.valueOf(nums[start]));


        return ans;

    }
}

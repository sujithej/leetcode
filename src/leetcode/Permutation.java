package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 11/07/15
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Permutation {
    public static void main(String []args)
    {
        int []nums = {1,2,3,4,5,6};
        List<List<Integer>> ans = (new Permutation()).permute(nums);
        System.out.println("hold");
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<List<Integer>>();
        permuteUtil(nums,ans,0);
        return ans;
    }


    public void permuteUtil(int []nums,List<List<Integer>> ans,int start)
    {
        if(start == nums.length)
        {
            ans.add(convertArrayToList(nums));
            return;
        }

        for(int i=start; i<nums.length;i++ )
        {
            swap(nums,start,i);
            permuteUtil(nums,ans,start+1);
            swap(nums,start,i);
        }

    }

    public void swap(int []nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }

}

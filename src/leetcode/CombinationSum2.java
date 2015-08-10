package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 11/07/15
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum2 {
    public static void main(String []args)
    {
        int []nums = {10,1,2,7,6,1,5};
        List<List<Integer>> ans = (new CombinationSum2()).combinationSum2(nums,8);
        System.out.println("hold");
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> currentList = new ArrayList<Integer>();
        HashSet<List<Integer>> duplicates= new HashSet<List<Integer>>();
        Arrays.sort(candidates);

        combinationSumUtil(ans, currentList, candidates, target, 0,duplicates);
        return ans;
    }

    public void combinationSumUtil(List<List<Integer>> ans,List<Integer> currentList,int[] candidates,int target,int currentPostition,HashSet<List<Integer>> duplicates)
    {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(target < 0)
            return;
        if(target == 0)
        {
            if(!duplicates.contains(currentList))
            {
                duplicates.add(currentList);
                ans.add(currentList);
                return;
            }


        }
        for(int i= currentPostition; i < candidates.length && candidates[i] <= target; i++)
        {
            if(currentList == null)
            {
                currentList = new ArrayList<Integer>();
            }

            temp = new ArrayList<Integer>(currentList);
            temp.add(candidates[i]);
            combinationSumUtil(ans,temp,candidates,target-candidates[i],i+1,duplicates);
        }


    }
}

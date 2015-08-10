package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 11/07/15
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> currentList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumUtil(ans,currentList,candidates,target,0);
        return ans;
    }

    public void combinationSumUtil(List<List<Integer>> ans,List<Integer> currentList,int[] candidates,int target,int currentPostition)
    {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(target < 0)
            return;
        if(target == 0)
        {
            ans.add(currentList);
            return;

        }
        for(int i= currentPostition; i < candidates.length && candidates[i] <= target; i++)
        {
            if(currentList == null)
            {
                currentList = new ArrayList<Integer>();
            }

            temp = new ArrayList<Integer>(currentList);
            temp.add(candidates[i]);
            combinationSumUtil(ans,temp,candidates,target-candidates[i],i);
        }


    }
}

import java.util.*;

/**
 * Created by sujith.j on 25/10/15.
 */
public class PermutationII {
//    Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//    For example,
//    [1,1,2] have the following unique permutations:
//            [1,1,2], [1,2,1], and [2,1,1].

    public static void main(String []args)
    {
        int []nums = {1,1,2};
        List<List<Integer>> ans = (new PermutationII()).permuteUnique(nums);
        System.out.println("hold");

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<List<Integer>>();
        List<Integer> temp  = new ArrayList<Integer>();
        HashSet<List<Integer>> duplicates = new HashSet<List<Integer>>();
        permuteUtil(nums,ans,0,duplicates);
        return ans;
    }

    public void permuteUtil(int []nums,List<List<Integer>> ans,int start,HashSet<List<Integer>> duplicates)
    {
        if(start == nums.length)
        {
            ArrayList<Integer> temp = convertArrayToList(nums);
            if(!duplicates.contains(temp)) {
                ans.add(temp);
                duplicates.add(temp);
            }
            return;
        }

        for(int i=start; i<nums.length;i++ )
        {
            swap(nums,start,i);
            permuteUtil(nums,ans,start+1,duplicates);
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

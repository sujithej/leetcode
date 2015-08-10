package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 01/07/15
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> ans = (new FourSum()).fourSum(nums, 0);
        System.out.println("break");
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<ArrayList<Integer>> duplicates = new HashSet<ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Combination>> combinationHashMap = new HashMap<Integer, ArrayList<Combination>>();
        ArrayList<Combination> temp = new ArrayList<Combination>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length < 4)
            return ans;
        generateCombinations(nums, combinationHashMap);

        for (int x : combinationHashMap.keySet()) {
            temp = combinationHashMap.get(target - x);
            if (temp != null) {
                for (Combination c1 : combinationHashMap.get(x)) {
                    for (Combination c2 : temp) {
                        validateAddInput(c1, c2, ans, duplicates, nums);
                    }
                }
            }


        }
        return ans;


    }


    public void validateAddInput(Combination c1, Combination c2, List<List<Integer>> ans, HashSet<ArrayList<Integer>> duplicates, int[] nums) {
        Integer[] index = {c1.pos1, c1.pos2, c2.pos1, c2.pos2};
        Arrays.sort(index);
        if (index[0] == index[1] || index[1] == index[2] || index[2] == index[3])
            return;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Integer[] tempnums = {nums[index[0]],nums[index[1]],nums[index[2]],nums[index[3]]};
        Arrays.sort(tempnums);
        temp.add(tempnums[0]);
        temp.add(tempnums[1]);
        temp.add(tempnums[2]);
        temp.add(tempnums[3]);


        boolean duplicate = duplicates.contains(temp);
        if (!duplicate) {
            duplicates.add(temp);
            ans.add(temp);
        }


    }


    public void generateCombinations(int[] nums, HashMap<Integer, ArrayList<Combination>> combinationHashMap) {
        ArrayList<Combination> temp;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                temp = combinationHashMap.get(sum);
                if (temp == null) {
                    temp = new ArrayList<Combination>();
                    combinationHashMap.put(sum, temp);
                }
                temp.add(new Combination(i, j));
            }
        }
    }

    class Combination {
        int pos1, pos2;

        Combination(int pos1, int pos2) {
            this.pos1 = pos1;
            this.pos2 = pos2;

        }
    }
}

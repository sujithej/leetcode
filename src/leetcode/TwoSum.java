package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 10/06/15
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {



    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> indexValue = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (indexValue.containsKey(nums[i])) {
                ArrayList<Integer> arrayList = indexValue.get(nums[i]);
                arrayList.add(i);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                arrayList.add(i);
                indexValue.put(nums[i], arrayList);
            }


        }

        for (int i = 0; i < nums.length; i++) {
            int index1 = -1, index2 =-1;
            index1 = indexValue.get(nums[i]).get(0);
            ArrayList<Integer> valueList = indexValue.get(target - nums[i]);
            if (valueList != null)
                index2 = valueList.get(0);
            if (index2 != -1 && index1 == index2 && indexValue.get(nums[i]).size() > 1) {
                index2 = valueList.get(1);
            }

            if (index2 != -1 && index1 != index2) {
                int ans[] = {index1, index2};
                return ans;


            }


        }

        int defaultans[] = {1, 1};
        return defaultans;
    }




}




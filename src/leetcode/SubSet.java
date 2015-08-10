package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 08/08/15
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubSet {

    public static void main(String []args)
    {
        int []nums = {1,2,2};
        List<List<Integer>> ans = (new SubSet()).subsetsWithDup(nums);
        System.out.println("hold");
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp;
        HashSet<List<Integer>> duplicates = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        boolean []sequence = new boolean[nums.length];
        for (int i=0;i<sequence.length;i++) {
            sequence[i] = false;
        }
        while(!terminateCondition(sequence))
        {
            temp = new ArrayList<Integer>();
            for (int i=0;i<sequence.length;i++) {
                if(sequence[i])
                {
                    temp.add(nums[i]);
                }
            }
            if(!duplicates.contains(temp))
            {
                ans.add(temp);
                duplicates.add(temp);

            }

            addToSequence(sequence);
        }
        temp = new ArrayList<Integer>();
        for (int i=0;i<sequence.length;i++) {
            if(sequence[i])
            {
                temp.add(nums[i]);
            }
        }
        ans.add(temp);
        return ans;


    }

    public boolean terminateCondition(boolean []sequence)
    {
        boolean flag = true;
        for (boolean b : sequence) {
            if(!b)
            {
                flag =false;
                break;
            }

        }
        return flag;





    }


    public void addToSequence(boolean []sequence)
    {

        boolean carry = true;
        for (int i=0;i<sequence.length;i++) {
            if(sequence[i] && carry)
            {
                carry = true;
                sequence[i] = false;
            }
            else if(!sequence[i] && !carry)
            {

            }
            else
            {
                carry = false;
                sequence[i] = true;
            }

        }
    }

}

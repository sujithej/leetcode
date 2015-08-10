package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 04/07/15
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int randomPivot;



        return ans;
    }

    public List<Integer> fetchAns(int []nums,int start,int end,int noOfOccurences)
    {


        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        Integer temp;
        int maxOccurences = (end-start+1)/noOfOccurences;
        boolean flag = true;
        for(int i=start;i<=end;i++)
        {
            temp  = hashMap.get(nums[i]);
            if(temp == null)
                hashMap.put(nums[i],0);
            else
                hashMap.put(nums[i],temp+1);

            if(hashMap.size() > maxOccurences )
            {
                flag = false;
                break;
            }

        }
        return null;



    }


    public int  randomIndex(int length,int start)
    {
        return (int)Math.random()*(length+1)+start;
    }

    public  int quickSort(int []nums,int pivot,int start,int end)
    {
       while(start <= end)
       {
           if(nums[start] > pivot)
           {
               swap(nums,start,end);
               end --;
           }
           else
           {
               start++;
           }
       }
        return end;

    }

    public void  swap(int []nums,int pos1,int pos2)
    {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}

/**
 * Created by sujith.j on 29/10/15.
 */

class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
public class DeleteDuplicate {
    public static void main(String []args)
    {
        int []arr = {1,1,1,2,2};
        System.out.println((new DeleteDuplicate()).removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        int length =0;
        int maxIndex = nums.length;
        for(int i=0;i<maxIndex;i++)
        {
            if(i+2 >= maxIndex || nums[i] != nums[i+2])
                length++;

        }
        return length;

    }
}

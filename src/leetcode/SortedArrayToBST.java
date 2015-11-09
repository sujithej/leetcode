/**
 * Created by sujith.j on 07/11/15.
 */
public class SortedArrayToBST {

    public static void main(String []args)
    {
        int []nums = {1,2,3,4,5,6,7};
        TreeNode root  = (new SortedArrayToBST()).sortedArrayToBST(nums);
        System.out.println("hold");
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int length = 0;

        while(temp != null)
        {
            length++;
            temp = temp.next;
        }
        int []nums = new int[length];
        for(int i =0; i< length;i++)
        {
            nums[i] = head.val;
            head = head.next;
        }
        return sortedArrayToBST(nums);


    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTUtil(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBSTUtil(int []nums,int start,int end)
    {
        if(start > end )
            return null;
        if(start == end)
            return (new TreeNode(nums[start]));
        int mid = start +(end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTUtil(nums,start,mid-1);
        node.right = sortedArrayToBSTUtil(nums,mid+1,end);
        return node;
    }
}

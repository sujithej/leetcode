package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 02/07/15
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root ;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return  l1;
        if(l1.val < l2.val)
        {
            root = l1;
            l1 = l1.next;
        }
        else
        {
            root = l2;
            l2 =l2.next;
        }
        ListNode temp = root;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                temp.next = l1;
                l1=l1.next;
                temp = temp.next;
            }
            else
            {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;

            }

        }
        if(l1 == null)
        {
            temp.next = l2;
        }
        else
        {
            temp.next = l1;
        }




        return root;
    }
}

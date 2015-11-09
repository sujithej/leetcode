import java.util.List;

/**
 * Created by sujith.j on 01/11/15.
 */



public class PartitionList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String []args)
    {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode less = null;
        ListNode temp = head.next;
        ListNode temp1  = head;
        ListNode max = null;
        if(temp1.val < x)
            less = temp1;
        else
            max = temp1;

        while(max == null && temp1 !=null)
        {
            if(temp1.val >= x) {
                max = temp;
            }
            else
                temp1 = temp1.next;

        }

        temp1 = head;



        while(less == null)
        {
            if(temp.val < x)
            {
                less = temp;
                temp1.next = temp.next;
                temp = temp.next;
            }
            else
            {
                temp1 = temp1.next;
                temp = temp.next;
            }
        }
        temp = head;
        while(temp != null) {
            if (temp.val < x) {
                less.next = temp;
                less = less.next;
                temp1.next = temp.next;
                temp = temp.next;
            } else {
                temp1 = temp1.next;
            }
        }
        less.next = head;
        return less;
    }

}

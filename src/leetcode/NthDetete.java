package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 19/06/15
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */



public class NthDetete {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        for(int i=0 ;i < n;i++)
            temp2 = temp2.next;
        if(temp2.next == null)
            return temp1.next;
        temp2 = temp2.next;
        while(temp2.next != null)
        {
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        temp1.next = temp1.next.next;
        return head;
    }
}

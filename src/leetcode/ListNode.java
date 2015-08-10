package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 19/06/15
 * Time: 11:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void printNodes(ListNode head)
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();

    }
}

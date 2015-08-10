package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 12/07/15
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class IsPlaindromeLinkedList {

    public static void main(String []args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        boolean flag = (new IsPlaindromeLinkedList()).isPalindrome(head);
        System.out.println(flag);

    }


    public boolean isPalindrome(ListNode head) {
        int length=0;
        ListNode temp = head;
        while(temp != null)
        {
            length++;
            temp = temp.next;
        }
        if(length == 1 || head == null)
            return true;
        temp =head;
        for(int i=0;i<length/2-1;i++)
            temp = temp.next;


        ListNode temp1,temp2;
        if(length%2 ==1) {
            temp2 = temp.next.next;
        }
        else {
            temp2 = temp.next;
        }
        temp.next = null;

        temp1 = reverseList(head);
        while(temp2 != null)
        {
            if(temp1.val != temp2.val)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;

    }


    public ListNode reverseList(ListNode head) {
        ListNode temp1,temp2,temp3,temp4;
        temp4 = null;
        temp1 = head;
        if(head == null)
            return head;
        int i =0;

        while(temp1 != null)
        {
            i++;
            temp2 = temp1.next;
            temp1.next = temp4;
            if(temp2 == null)
                return temp1;
            temp3 = temp2 .next;
            temp2.next = temp1;
            temp4 = temp2;
            temp1 = temp3;

        }


        return temp4;
    }
}

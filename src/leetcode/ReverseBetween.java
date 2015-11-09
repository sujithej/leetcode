/**
 * Created by sujith.j on 05/11/15.
 */
public class ReverseBetween {

    public static void main(String []args)
    {
        ListNode root = new ListNode(1);
        ListNode temp = root ;
        for(int i= 2 ; i <7 ; i++)
        {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        root = (new ReverseBetween()).reverseBetween(root,1,6);
        System.out.println("hold");


    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return head;
        ListNode temp  = head;
        for(int i=2; i< m ;i++)
            temp = temp.next;
        if(m != 1)
            temp.next = reverseStart(temp.next,n-m+1);
        else
            head = reverseStart(head,n-m+1);
        return head;

    }

    public ListNode reverseStart(ListNode head,int n)
    {
        ListNode temp = head;
        ListNode temp1 = head.next;
        ListNode temp2 = head.next.next;
        for(int i=1;i<n;i++)
        {

            temp1.next = temp;
            if(temp2 == null)
            {
                head.next  = temp2;
                return temp1;
            }
            temp = temp1;
            temp1=temp2;
            temp2 = temp2.next;

        }
        head.next  = temp1;

        return temp;

    }
}

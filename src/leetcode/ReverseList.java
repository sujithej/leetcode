package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 22/06/15
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseList {
    public static void main(String []args)
    {
        ListNode root = new ListNode(1);
        ListNode temp = root ;
        for(int i= 2 ; i <7 ; i++)
        {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode.printNodes(root);
        root = (new ReverseList()).reverseList(root);
        ListNode.printNodes(root);

    }


    public ListNode reverseList(ListNode head) {
        ListNode temp1,temp2,temp3,temp4;
        temp4 = null;
        temp1 = head;
        if(head == null)
            return head;


        {

            temp2 = temp1.next;
            temp1.next = temp4;
//            System.out.println(temp1.val + " " + temp2.val + " "+temp3.val + " "+ temp4.val);
            if(temp2 == null)
                return temp1;
            temp3 = temp2 .next;
            temp2.next = temp1;
            temp4 = temp2;
            temp1 = temp3;
//            System.out.println(temp1.val + " " + temp2.val + " "+temp3.val + " "+ temp4.val);

        }


        return temp4;
    }
}

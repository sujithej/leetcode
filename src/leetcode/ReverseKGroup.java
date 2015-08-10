package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 19/06/15
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */








public class ReverseKGroup {

    public static void main (String args[])
    {
        ListNode temp1 = new ListNode(1);
        ListNode head = temp1;
        for(int i = 2; i <11 ;i++)
        {
            temp1.next = new ListNode(i);
            temp1 = temp1.next;
        }
        printNodes(head);
        head = (new ReverseKGroup()).reverseKGroup(head,4);
        printNodes(head);

    }

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


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        ListNode temp3 = null;
        ListNode temp4 = null;
        int j =0;

        if(head == null)
            return head;
        for(int i=0 ;i < k-1 && temp2.next != null  ;i++)
        {
            j++;
            temp2 = temp2.next;
        }

        if(j < k-1)
        {
            return head;
        }
        else
            j=0;


        temp4 = temp2.next;
        reverseList(temp1,temp2);
        head = temp2;
        temp1.next = temp4;
        temp3 = temp1;
        temp1 = temp1.next;
        temp2 = temp1;

        if(temp4 == null)
        {
            return head;


        }



        while(true)
        {

            for(int i=0 ;i < k-1 && temp2.next != null  ;i++)
            {
                j++;
                temp2 = temp2.next;
            }
            if(j < k-1)
            {
                return head;
            }
            else
                j=0;

            temp4 = temp2.next;
            reverseList(temp1,temp2);

            if(temp4 == null)
            {
                temp3.next = temp2;
                temp1.next = null;
                break;
            }
            else
            {
                temp3.next = temp2;
                temp3 = temp1;
                temp1.next = temp4;
                temp1 = temp4;
                temp2 = temp4;

            }



        }





        return head;






    }

    public ListNode reverseList(ListNode a,ListNode b)
    {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = a;
        while(temp != b && temp != null)
        {
            stack.push(temp);
            temp = temp.next;
        }
        ListNode head = temp;
        while(!stack.empty())
        {
            temp.next = stack.pop();
            temp = temp.next;
        }


        return head;

    }



}

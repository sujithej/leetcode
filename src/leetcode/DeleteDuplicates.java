import java.util.List;

/**
 * Created by sujith.j on 03/11/15.
 */
public class DeleteDuplicates {

    public static void main(String []args)
    {
        ListNode start =  new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(2);
        (new DeleteDuplicates()).deleteDuplicates(start);
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode lastUnique  = null;
        ListNode temp = head;
        ListNode startUnique = null;
        while(startUnique == null && temp != null)
        {
            if(temp.next == null || temp.val != temp.next.val)
                startUnique = temp;
            else
                temp = deleteStartDuplicate(temp);
        }
        if(startUnique == null)
            return startUnique;
        lastUnique = startUnique;
        temp = temp.next;
        while(temp!=null)
        {
            if(temp.next == null || temp.val !=temp.next.val)
            {
                lastUnique.next = temp;
                temp = temp.next;
                lastUnique = lastUnique.next;
            }
            else
            {
                temp = deleteStartDuplicate(temp);
            }
        }
        lastUnique.next = null;




        return startUnique;

    }
    public ListNode deleteStartDuplicate(ListNode temp)
    {
        int val = temp.val;
        while(temp!=null && temp.val == val)
            temp = temp.next;
        return temp;
    }
}

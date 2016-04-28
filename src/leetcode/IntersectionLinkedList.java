/**
 * Created by sujith.j on 27/04/16.
 */
public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null){sizeA++; tempA = tempA.next;}
        while(tempB != null){sizeB++;tempB = tempB.next;}
        tempA = headA;
        tempB = headB;
        if(sizeA > sizeB) {
            for(int i =0 ; i < sizeA - sizeB ; i++) {
                tempA = tempA.next;
            }
        } else {
            for(int i =0 ; i < sizeB - sizeA ; i++) {
                tempB = tempB.next;
            }
        }
        while(tempA != null) {
            if(tempA == tempB){
                return tempA;
            }
            tempA  = tempA.next;
            tempB  = tempB.next;
        }
        return tempA;
    }

    public static void main(String []args) {
        ListNode a  = new ListNode(4);
        (new IntersectionLinkedList()).getIntersectionNode(a,null);
    }

}

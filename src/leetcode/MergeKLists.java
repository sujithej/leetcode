package leetcode;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 27/06/15
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class MergeKLists {

    public static void main(String []args)
    {
        ListNode []lists = {new ListNode(1),new ListNode(0)};
        (new MergeKLists()).mergeKLists(lists);
    }


    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNodeComparable> heap = new PriorityQueue<ListNodeComparable>();
        ListNodeComparable tempListNodeComparable;
        ListNode temp;
        for(ListNode l:lists)
        {
            if(l != null)
            {
                tempListNodeComparable = new ListNodeComparable(l);
                heap.add(tempListNodeComparable);
            }
        }

        if(heap.peek() ==  null)
            return null;
        ListNode root = (heap.poll()).p;
        temp = root;

        if(root.next != null)
            heap.add(new ListNodeComparable(root.next));

        while(!heap.isEmpty())
        {
           temp.next =  (heap.poll()).p;
           temp = temp.next;
           if(temp.next != null)
               heap.add(new ListNodeComparable(temp.next));



        }
        return root;




    }

    class ListNodeComparable implements Comparable<ListNodeComparable>
    {
        private  ListNode p;

        ListNodeComparable(ListNode p)
        {
            this.p = p;

        }

        @Override
        public int compareTo(ListNodeComparable o) {
            return Integer.compare(p.val,o.p.val);

        }
    }
}

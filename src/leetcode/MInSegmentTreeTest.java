package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 25/06/15
 * Time: 8:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class MInSegmentTreeTest {

    public static void main(String []args)
    {


        Comparator comparator = new MaxHeapComparator();
        PriorityQueue<Integer> p  = new PriorityQueue<Integer>(11, comparator);
        p.add(2);
        p.add(5);
        p.add(1);
        p.add(3);
        System.out.println(p.poll());

    }



}

class MaxHeapComparator implements Comparator<Comparable>
{

    @Override
    public int compare(Comparable o1, Comparable o2) {
        return o2.compareTo(o1);
    }
}



class Node
{
    public int compareTo (Comparable t,Comparable x)
    {
        return t.compareTo(x);

    }
}

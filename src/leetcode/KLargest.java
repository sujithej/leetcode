package leetcode;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 18/06/15
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class KLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
        if(nums.length == 0 || k==0 || nums.length < k)
            return 0;
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);

        }
        for(int i =k ;i<nums.length ; i++ )
        {
            int temp = heap.peek();
            if(nums[i] > temp)
            {
                heap.poll();
                heap.add(nums[i]) ;
            }
        }



        return heap.peek();



    }
}

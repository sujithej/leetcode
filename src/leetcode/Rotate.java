package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 27/06/15
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        (new Rotate()).rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        if (k > nums.length)
            k = k % nums.length;
        rotateUtil(nums, k, 0, nums.length - 1);

    }

    public void rotateUtil(int[] nums, int k, int start, int end) {
        if (k == 0 || k > end - start)
            return;
        int temp = (end + 1 - k) % k;
        for (int i = end - k; i >= 0; i--)
            swap(nums, i, i + k);
        if (temp == 0)
            return;
        rotateUtil(nums, k - temp, 0, k - 1);
    }


    public void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
}

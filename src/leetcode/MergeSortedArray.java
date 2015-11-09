/**
 * Created by sujith.j on 03/11/15.
 */
public class MergeSortedArray {
    public static void main(String []args)
    {
        int []nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 4;
        nums1[3] = 5;
        nums1[4] = 6;
        nums1[5] = 0;

        int []nums2 = {3};
        (new MergeSortedArray()).merge(nums1,5,nums2,1);
        System.out.println("hold");
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m-1 ;i>=0;i--)
            nums1[i+n] = nums1[i];
        int index1 = n;
        int index2 = 0;
        int index = 0;
        while(index2 < n)
        {
            if(index1 < m+n && nums1[index1] < nums2[index2])
                nums1[index++] = nums1[index1++];
            else
                nums1[index++] = nums2[index2++];
        }

    }
}

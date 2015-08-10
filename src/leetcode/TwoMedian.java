package leetcode;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 14/06/15
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class TwoMedian {


    public static void main(String []args)
    {
        int []nums1 = {1,2,3,4,6,7};
        int []nums2 = {5};
        System.out.println((new TwoMedian()).findMedianSortedArrays(nums1, nums2));
    }




    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        if(nums1.length == 0 && nums2.length ==0)
            return 0;

        if(nums2.length > 0 && (nums1.length == 0 || nums2[nums2.length -1] <= nums1[0]))
        {
            int nums[] = nums1;
            nums1 = nums2;
            nums2 = nums;
        }


        int temp = 0;
        int m = nums1.length;
        int n = nums2.length;
        int mstart = 0;
        int mend = m - 1;
        int medianindex = (m + n) / 2 ;
        int nindex =-1, mindex =-1,tempindex,tempnindex;
        boolean even = (m+n)%2 == 0;


        tempindex = (mstart + mend) / 2;





        if(n==0 || nums1[m-1] <= nums2[0] )
        {
            if(m == medianindex && even)
            {
                return (nums1[medianindex-1] + nums2[0])/2.0;
            }

            if(m <= medianindex)
            {
                int index= (medianindex - m);
                if(even)
                {
                    return (nums2[index]+nums2[index-1])/2.0;

                }
                else
                {
                    return nums2[index];

                }

            }
            else
            {
                int index = medianindex;
                if(even)
                {
                    return (nums1[index]+nums1[index-1])/2.0;

                }
                else
                {
                    return nums1[index];

                }

            }





        }


        while (true) {

            if(tempindex < 0)
            {
                mindex = -1;
                nindex = 0;
                break;
            }

            tempnindex = binaryInsertPosition(nums2, 0, n - 1, nums1[tempindex]);
          //  System.out.println(nindex);
            if (tempnindex + tempindex <= medianindex)
            {
                mindex = tempindex;
                nindex = tempnindex;
            }





            if (tempnindex + tempindex  == medianindex || (mstart == mend || mstart > mend)) {
                break;

            } else {
                if (tempnindex + tempindex < medianindex) {
                    mindex = tempindex;
                    nindex = tempnindex;

                    mstart = tempindex + 1;
                    tempindex = (mstart + mend) / 2;

                } else {
                    mend = Math.min(tempindex - 1,medianindex-nindex);
                    tempindex = (mstart + mend) / 2;
                }

                if(mstart + nindex > medianindex )
                    break;




            }


        }



        if (mindex + nindex == medianindex) {
            if ((m + n) % 2 == 1) {
                return nums1[mindex];
            } else {
                int num1 = nindex == 0 ? 0 : nums2[nindex-1] ;
                int num2 = mindex == 0 ? 0 : nums1[mindex-1];
                return (nums1[mindex] + Math.max(num1,num2))/ 2.0;
            }
        } else {
           int index = medianindex -(mindex+1);
           if(!even)
           {
//               return nums2[index];
               if(nums2.length <= index)
               {
                   int y = mindex + 1+index - (nums2.length);
                   return nums1[y];
               }
               else
                    return nums2[index];



           }
           else
           {
               int num1,num2;

               int tempmed  ;
               if(nums2.length <= index)
               {
                   int y = mindex + 1+index - (nums2.length);
                   tempmed = nums1[y];
                   num1 = (y==0) ? 0 : nums1[y-1];
                   num2 = (nums2.length == index) ? nums2[index-1] : 0;
               }
               else
               {
                   tempmed = nums2[index];
                   num1 = (index ==0) ? 0 : nums2[index-1];
                   num2 = (mindex == -1) ? 0 : nums1[mindex];
               }


               return (tempmed + Math.max(num1,num2))/2.0;
           }



        }


    }

    public int binaryInsertPosition(int[] arr, int start, int end, int x) {
//        System.out.println("start :" + start + "end :" + end + "ar "+arr[0]+" "+arr[1] +  "x "+x );

        if (x < arr[start]) {
            return (start);
        }
        if (x >= arr[end]) {
           System.out.println("sdlfhsoidfhsodi");
            return (end + 1);
        }
        if(x == arr[start])
            return start+1;
        int pos = (start + end) / 2;
        if (x >= arr[pos] && x < arr[pos + 1]) {
            return pos+1;
        } else {
            if (x < arr[pos]) {
                return binaryInsertPosition(arr, start, pos - 1, x);
            } else {
                return binaryInsertPosition(arr, pos+1, end , x);
            }
        }


    }

}

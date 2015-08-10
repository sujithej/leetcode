package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 07/07/15
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class LargestInteger {
    public static void main(String[] args) {
        int[] nums = {121,12    };
        String ans = (new LargestInteger()).largestNumber(nums);
        System.out.println(ans);

    }


    public String largestNumber(int[] nums) {
        Point[] points = new Point[nums.length];
        boolean flagZeroes =true;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                flagZeroes = false;
            points[i] = new Point(nums[i]);

        }
        if(flagZeroes)
            return "0";

        Arrays.sort(points);
        String ans = "";
        for (Point point : points) {
            ans = ans + point.val;
        }
        return ans;
    }
}

class Point implements Comparable<Point> {
    String val;

    Point(int val) {
        this.val = String.valueOf(val);
    }

    @Override
    public int compareTo(Point o) {
        String temp1 = this.val;
        String temp2 = o.val;
        return compareUtil(temp1,temp2);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int compareUtil(String temp1,String temp2)
    {
        int len = Math.min(temp1.length(), temp2.length());
        for (int i = 0; i < len; i++) {
            if (temp1.charAt(i) > temp2.charAt(i))
                return -1;
            if (temp1.charAt(i) < temp2.charAt(i))
                return 1;
        }
        if (temp1.length() == temp2.length())
            return 0;
        if(temp1.length() < temp2.length())
            return compareUtil(temp1,temp2.substring(temp1.length()));
        else
            return compareUtil(temp1.substring(temp2.length()),temp2);
    }
}

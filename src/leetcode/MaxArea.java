package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
* Created with IntelliJ IDEA.
* User: sujith.j
* Date: 25/06/15
* Time: 7:34 PM
* To change this template use File | Settings | File Templates.
*/
public class MaxArea {

    public static void main(String []args)
    {
        int []heights = {1,1};
        System.out.println((new MaxArea()).maxArea(heights));
    }

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length -1;
        int localmaxima = 0;
        int globalmaxima = 0;

        while(start < end)
        {
            localmaxima = Math.min(height[start],height[end])*(end-start+1);
            if(localmaxima > globalmaxima)
                globalmaxima = localmaxima;
            if(height[start] < height[end])
            {
                start++;
            }
            else
            {
                end--;
            }


        }


        return globalmaxima;

    }


}


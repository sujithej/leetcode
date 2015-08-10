package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 24/06/15
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinSegmentTree {

    private int []st;
    private int numSize;
    private final int MAXINT = Integer.MAX_VALUE;

    MinSegmentTree(int []nums)
    {

        this.numSize = nums.length;
        int x = (int)Math.ceil(Math.log(nums.length)/Math.log(2));
        this.st = new int[2*(int)Math.pow(2,x) -1 ];
//        System.out.println(st.length);
        generateMinSegmentTree(nums,0,nums.length-1,this.st,0);

    }

    public void printSegmentTree()
    {
        for(int i:st)
            System.out.println(i);

    }

    public int generateMinSegmentTree(int []nums,int ss,int se,int []st,int cp)
    {

        if(ss == se)
        {
            st[cp] = nums[ss];
            return nums[ss];
        }

        int mid = getmid(ss,se);
        st[cp] = Math.min(generateMinSegmentTree(nums,ss,mid,st,2*cp+1),generateMinSegmentTree(nums,mid+1,se,st,2*cp+2));
//        System.out.println("ss" +ss +"se" + se + "val" + st[cp]);
        return st[cp];
    }

    public int getmid(int a,int b)
    {
        return (a+b)/2;
    }

    public int getMin(int qs , int qe)
    {
        int ss =0;
        int se = numSize-1;
        if(qs < 0 || qe > se )
        {
            return(-1);
        }

        return getMinUtil(this.st,qs,qe,ss,se,0);

    }

    public int getMinUtil(int []st,int qs,int qe,int ss,int se,int cp)
    {
//        System.out.println("ss" +ss +"se" + se + "val" + cp);
        if(ss >= qs && se <= qe )
            return st[cp];

        if (se < qs || ss > qe)
            return MAXINT;

        int mid = getmid(ss, se);

        return Math.min(getMinUtil(st, qs, qe, ss, mid, 2 * cp + 1),
                getMinUtil(st, qs, qe, mid + 1, se, 2 * cp + 2));

    }

}

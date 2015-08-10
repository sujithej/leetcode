package leetcode;

import java.io.BufferedReader;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 27/06/15
 * Time: 10:33 AM
 * To change this template use File | Settings | File Templates.
 */




public class LargestRectangleArea {
    public static void main(String []args)

    {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(2147483646);

        int []heights = {0,0,0,0,0,0,0,0,2147483647};


        Date date = new Date();
        date.getTime();
        System.out.println((new LargestRectangleArea()).largestRectangleArea(heights));
        date = new Date();
        date.getTime();


    }

    public int largestRectangleArea(int[] height) {
        Position []posHeights = new Position[height.length];
        Position Maximum =new Position(Integer.MAX_VALUE,Integer.MAX_VALUE -1);
        if(height.length == 0)
            return 0;
        for(int i=0;i<height.length;i++)
        {
            posHeights[i] = new Position(height[i],i);
        }
        MinSegmentTreeGeneric1 st  = new MinSegmentTreeGeneric1(posHeights,Maximum);
//        Comparable temp1 = st.getMin(8,8);
//        System.out.println(st.getMin(7,7));


        return maxAreaUtil(posHeights,0,0,height.length-1,st);



    }

    public int maxAreaUtil(Position []posHeights,int globalMax,int start,int end,MinSegmentTreeGeneric1 st)
    {
        if(start > end)
        {
            return globalMax;
        }

        Position minpos = (Position)st.getMin(start,end);
        int localMax = (int)minpos.height*(end - start + 1);
        if(localMax > globalMax)
        {
            globalMax = localMax;
        }
        Stack<StackUtil> stack = new Stack<StackUtil>();
        stack.push(new StackUtil(start,minpos.index-1));
        stack.push(new StackUtil(minpos.index+1,end));
        StackUtil temp ;

        while(!stack.isEmpty())
        {
            temp = stack.pop();
            start = temp.start;
            end = temp.end;
            if(start <= end && end < posHeights.length)
            {

//                System.out.println(start + "start" + end + "end");
                minpos = (Position)st.getMin(start,end);
                localMax = (int)minpos.height*(end - start + 1);
                if(localMax > globalMax)
                {
                    globalMax = localMax;
                }
//                System.out.println(globalMax);
                stack.push(new StackUtil(start,minpos.index-1));
                stack.push(new StackUtil(minpos.index+1,end));
            }

        }

        return globalMax;


//        int temp1 = maxAreaUtil(posHeights,globalMax,start,minpos.index-1,st);
//        int temp2 = maxAreaUtil(posHeights,globalMax,minpos.index+1,end,st);
//        int temp3 =  Math.max(temp1,temp2);
//        return Math.max(temp3,globalMax);

    }






}

class StackUtil
{
     int start, end;

    StackUtil(int start, int end) {

        this.start = start;
        this.end = end;
    }
}

class Position implements  Comparable<Position>
{
    int height;
    int index;
    Position(int height,int index)
    {
        this.height = height;
        this.index = index;
    }


    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.height,o.height);  //To change body of implemented methods use File | Settings | File Templates.
    }
}




class MinSegmentTreeGeneric1 {



    private Comparable[] st;
    private int numSize;
    Comparable  MAXINT ;

    MinSegmentTreeGeneric1(Comparable []nums,Comparable Maximum)
    {

        this.numSize = nums.length;
        MAXINT = Maximum ;
        int x = (int)Math.ceil(Math.log(nums.length)/Math.log(2));
        this.st = new Comparable[2*(int)Math.pow(2,x) -1 ];
//        System.out.println(st.length);
        generateMinSegmentTree(nums,0,nums.length-1,this.st,0);

    }

    public void printSegmentTree()
    {
        for(Comparable i:st)
            System.out.println(i);

    }

    public Comparable generateMinSegmentTree(Comparable []nums,int ss,int se,Comparable []st,int cp)
    {

        if(ss == se)
        {
            st[cp] = nums[ss];
            return nums[ss];
        }

        int mid = getmid(ss,se);
        Comparable temp1 =generateMinSegmentTree(nums,ss,mid,st,2*cp+1);
        Comparable temp2 = generateMinSegmentTree(nums,mid+1,se,st,2*cp+2);

        if(temp1.compareTo(temp2) > 0)
        {
            st[cp] = temp2;
            return temp2;
        }
        else
        {
            st[cp] = temp1;
            return temp1;

        }



//        st[cp] = Math.min(,generateMinSegmentTree(nums,mid+1,se,st,2*cp+2));
//        System.out.println("ss" +ss +"se" + se + "val" + st[cp]);
//        return st[cp];
    }

    public int getmid(int a,int b)
    {
        return (a+b)/2;
    }

    public Comparable getMin(int qs , int qe)
    {
        int ss =0;
        int se = numSize-1;
        if(qs < 0 || qe > se )
        {
            return(-1);
        }

        return getMinUtil(this.st,qs,qe,ss,se,0);

    }

    public Comparable getMinUtil(Comparable []st,int qs,int qe,int ss,int se,int cp)
    {
//        System.out.println("ss" +ss +"se" + se + "val" + cp);
        if(ss >= qs && se <= qe )
            return st[cp];

        if (ss > qe  || se < qs)
            return MAXINT;

        int mid = getmid(ss, se);
        Comparable temp1 = getMinUtil(st, qs, qe, ss, mid, 2 * cp + 1);
        Comparable temp2 = getMinUtil(st, qs, qe, mid + 1, se, 2 * cp + 2);
        if(temp1.compareTo(temp2) > 0)
        {
            st[cp] = temp2;
            return temp2;
        }
        else
        {
            st[cp] = temp1;
            return temp1;

        }

    }

}


package  leetcode;

class MinSegmentTreeGeneric {



    private Comparable[] st;
    private int numSize;
    Comparable  MAXINT ;

    MinSegmentTreeGeneric(Comparable []nums,Comparable Maximum)
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
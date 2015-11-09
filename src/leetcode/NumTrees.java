/**
 * Created by sujith.j on 05/11/15.
 */
public class NumTrees {

    public static void main(String []args)
    {
        System.out.println((new NumTrees()).numTrees(3));
    }

    public int numTrees(int n) {
        int []count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        return numTreesUtil(n,count);
    }


    public int numTreesUtil(int n,int []count)
    {
        if(count[n] != 0)
            return count[n];

        int sum =0;
        for(int i= 0; i< n;i++)
        {
            sum += numTreesUtil(i,count) * numTreesUtil(n-1-i,count);
        }
        count[n] = sum;
        return sum;
    }
}

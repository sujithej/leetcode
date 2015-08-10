package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 18/06/15
 * Time: 11:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClimbingStairs {



    public int climbStairs(int n) {
        int temp1 = 1;
        int temp2 =1;
        int temp3 = 0;
        if(n < 2)
            return 1;
        for(int i=2 ; i<= n ;i++)
        {
            temp3 = temp1+temp2;
            temp1 = temp2;
            temp2 = temp3;
        }
        return temp3;

    }
}

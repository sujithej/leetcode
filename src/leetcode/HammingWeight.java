package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 27/06/15
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class HammingWeight {




    public int hammingWeight(int n) {
        long x = getUnsignedInt(n);

        int sum = (x >= 0) ? 0 : 1;
        while(x != 0)
        {
            if(x %2 == 1)
                sum += 1;
            x = x/2;
        }


        return sum;

    }

    public  long getUnsignedInt(int x) {
        return x & 0x00000000ffffffffL;
    }

}

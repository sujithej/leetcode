import java.util.ArrayList;

/**
 * Created by sujith.j on 26/10/15.
 */
public class PermutationSequence {
    public static void main(String [] args)
    {
        for(int i=1 ;i<= 24;i++)
            System.out.println((new PermutationSequence()).getPermutation(4,i));

    }
    public String getPermutation(int n, int k) {
        ArrayList<Integer> leftNums = new ArrayList<Integer>();
        int pos;
        int factorial;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++)
            leftNums.add(i);

        factorial = factorial(n);
        for(int i=0;i<n;i++)
        {
            factorial = factorial/(n-i);
            pos = (k-1)/factorial;
            sb.append(String.valueOf(leftNums.get(pos)));
            leftNums.remove(pos);
            k = (k-1)%factorial+1;
        }
        return sb.toString();
    }

    public int factorial(int n) {
        int product = 1;
        if(n<1)
            return 1;
        while(n != 1) {
            product = product*n;
            n--;
        }
        return product;

    }


}

package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 04/07/15
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class CountPrimes {

    public static void main(String []args)
    {
        int ans = (new CountPrimes()).countPrimes(10);
        System.out.println(ans);

    }

    public int countPrimes(int n) {
        boolean []primes = new boolean[n+1];
        int sum = 0;

        if(n <2)
            return 0;
        for(int i= 1; i <=n;i++ )
            primes[i] = true;

        for(int i=2 ; i < Math.sqrt(n);i++)
        {
            if(primes[i])
            {
                for(int j= i+i ; j<=n ;j+=i)
                    primes[j] = false;
            }
        }

        for(int i=2;i<n;i++)
            if(primes[i])
                sum++;


        return sum;
    }



}

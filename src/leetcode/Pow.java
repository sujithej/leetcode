/**
 * Created by sujith.j on 25/10/15.
 */
//Implement pow(x, n).
public class Pow {
    public static void main(String []args)
    {
        double x = (new Pow()).myPow(2,10);
        System.out.println(x);

    }

    public double myPow(double x,int n)
    {
        int sign = 1;
        if(n < 0)
        {
            sign = -1;
            n = -1*n;
        }
        String binary =  Integer.toBinaryString(n);
        double ans = 1;
        double multiplier = x;
        for(int i = binary.length()-1;i>=0;i--)
        {
            if(binary.charAt(i) == '1')
                ans = ans*multiplier;
            multiplier = multiplier*multiplier;

        }
        if(sign == -1)
            ans  = 1.0/ans;
        return ans;
    }
}

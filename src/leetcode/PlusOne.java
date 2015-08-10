package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 11/07/15
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlusOne {
    public static void main(String []args)
    {
        int []digits = {0};
        int []ans = (new PlusOne()).plusOne(digits);
        System.out.println("hold");
    }


    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for(int i:digits)
        {
            if( i!=9)
            {
                flag = false;
                break;
            }
        }
        int []ans;
        if(flag)
        {
            ans = new int[digits.length+1];
            ans[0] = 1;
            for(int i=1;i<ans.length;i++)
            {
                ans[i] = 0;
            }
            return ans;
        }
        else
        {
            ans = new int[digits.length];
        }
        int carry = 1;
        for(int i= digits.length-1;i >= 0;i--)
        {
            if(digits[i] == 9 &&  carry == 1)
            {
                ans[i] =0;
            }
            else
            {
                ans[i] = digits[i] + carry;
                carry=0;
            }
        }
        return ans;
    }
}

package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 14/06/15
 * Time: 8:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Integerreversal {

    public static void main(String []args)
    {
        System.out.println((new Integerreversal()).reverse(-10));
    }

    public int reverse(int x) {
        boolean sign;
        if(x < 0)
        {
            sign = false;
            x = x*-1;
        }else
        {
            sign = true;
        }

        int ans =0;
        String s = String.valueOf(x);
        char []charArray = new char[s.length()];
        char []tempArray = s.toCharArray();
        int maxIndex = s.length() -1;
        for(int i=0;i<s.length();i++)
        {
            charArray[i] = tempArray[maxIndex-i];

        }
        s = String.valueOf(charArray);
        ans = Integer.parseInt(s);


        if(!sign)
            ans = ans*-1;
        return ans;



    }
}

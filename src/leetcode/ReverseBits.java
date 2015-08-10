package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 27/06/15
 * Time: 8:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseBits {

public static void main(String []args)
{
    char []a = new char[5];
    a[0] = 'a';
    System.out.println((new String(a)).trim());
//    System.out.println((new ReverseBits()).reverseBits(5));
}


public int reverseBits(int n) {
    long x = getUnsignedInt(n);
    String s = Long.toBinaryString(x);
//    System.out.println(s);
    char []sourceArray = new char[64];
//    Arrays.fill(sourceArray, '0');
    for(int i=0; i< 64;i++)
        sourceArray[i] = '0';

    int j = 63;
    for (int i = s.length() - 1; i >= 0; i--) {
        sourceArray[j--] = s.charAt(i);
    }
    char []ans = new char[32];
    j =0;
    for(int i=63; i>31;i--)
    {
        ans[j++] = sourceArray[i];
    }
    String ansString = new String(ans);
//    System.out.println(ansString);
    return (int)Long.parseLong(ansString, 2);
//    return  0;
}

public  long getUnsignedInt(int x) {
    return x & 0x00000000ffffffffL;
}
}

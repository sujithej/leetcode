/**
 * Created by sujith.j on 27/10/15.
 */
public class MySqrt {
    public static void main(String []args)
    {
        System.out.println((new MySqrt()).mySqrt(2147483647));

    }
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int mid;
        long midSquare;
        while(start <= end)
        {
            mid = start+(end-start)/2;
            midSquare = (long)mid*(long)mid;
            if(midSquare <= x && (midSquare+2*mid+1) > x)
                return mid;
            if(midSquare < x)
                start = mid+1;
            else
                end = mid -1;
        }
        return -1;
    }
}

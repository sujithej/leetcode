package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 12/06/15
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
 */



public class ZigZag {

    public static void main(String []args)
    {
        ZigZag s = new ZigZag();
        System.out.println(s.convert("abc",3));

    }

    public String convert(String s, int numRows) {
        int increment =  2*numRows - 2;
        if(numRows == 1)
            return s;

        char []ans = new char[s.length()];
        int charIndex = 0;
        for(int i=0; i < numRows;i++)
        {
            int index1 = i;
            int index2  = increment -i;
            if(i == 0 || i == numRows-1 )
            {
                while(index1 < s.length())
                {

                    ans[charIndex++] =  s.charAt(index1);
                    index1= index1+increment;

                }
            }
            else
            {
                while(index1 < s.length())
                {

                    ans[charIndex++] = s.charAt(index1);
                    index1 =index1+increment;
                    System.out.println("sdghbfd");
                    System.out.println(index2);
                    if(index2 >= s.length())
                        break;
                    ans[charIndex++] = s.charAt(index2);
                    index2 +=  increment;




                }


            }

        }


        return new String(ans);

    }
}

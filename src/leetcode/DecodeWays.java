/**
 * Created by sujith.j on 30/10/15.
 */

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println((new DecodeWays()).numDecodings("8299152987184352183335613793611738246622952882892165423687431814339833963464637792247791375416898193"));
    }




    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.equals("0"))
            return 0;


        int[] t = new int[s.length() + 1];
        t[0] = 1;

        //if(s.charAt(0)!='0')
        if (isValid(s.substring(0, 1)))
            t[1] = 1;
        else
            t[1] = 0;

        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i - 1, i))) {
                t[i] += t[i - 1];
            }

            if (isValid(s.substring(i - 2, i))) {
                t[i] += t[i - 2];
            }
        }

        return t[s.length()];
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0')
            return false;
        int value = Integer.parseInt(s);
        return value >= 1 && value <= 26;
    }
}

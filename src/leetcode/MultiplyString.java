package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 31/07/15
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class MultiplyString {
    public static void main(String[] args) {
        System.out.println((new MultiplyString()).addReverseStrings("00518931000", "57402"));
        String output = (new MultiplyString()).multiply("2925", "4787");

        System.out.println(output);
    }


    public String multiply(String num1, String num2) {
        int carry = 0;
        int value = 0;
        String ans = "";
        String[] additions = new String[num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            additions[i] = "";
        }


        for (int i = num2.length() - 1; i >= 0; i--) {
            carry = 0;
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                additions[i] = additions[i].concat("0");
            }
            for (int j = num1.length() - 1; j >= 0; j--) {
                value = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + carry;
                carry = value / 10;
                additions[i] = additions[i].concat(String.valueOf(value % 10));
            }
            additions[i] = additions[i].concat(String.valueOf(carry));
        }

        for (int i = 0; i < num2.length(); i++) {
            ans = addReverseStrings(ans, additions[i]);
        }
        ans = reverseString(ans);
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != '0')
                return ans.substring(i);
        }
        return "0";


    }

    public String reverseString(String str) {
        String ans = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            ans = ans.concat(String.valueOf(str.charAt(i)));
        }
        return ans;

    }


    public String addReverseStrings(String num1, String num2) {

        int carry = 0;
        if (num1.length() > num2.length()) {
            String swapTemp = num1;
            num1 = num2;
            num2 = swapTemp;
        }

        String ans = "";
        int temp1 = 0, temp2 = 0, value = 0;

        for (int i = 0; i < num1.length(); i++) {
            value = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + carry;
            ans = ans.concat(String.valueOf(value % 10));
            carry = value / 10;
        }

        for (int i = num1.length(); i < num2.length(); i++) {
            value = (num2.charAt(i) - '0') + carry;
            ans = ans.concat(String.valueOf(value % 10));
            carry = value / 10;
        }
        ans = ans.concat(String.valueOf(carry));
        return ans;

    }
}

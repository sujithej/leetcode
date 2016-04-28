
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 19/07/15
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class LongestValidParentheses {
    public static void main(String []args)
    {
        int ans  = (new LongestValidParentheses()).longestValidParentheses(")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())");
        System.out.println(ans);
    }
    public int longestValidParentheses(String s) {
        int []ans = new int[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
                stack.push(i);
            else
            {
                if(!stack.isEmpty()) {
                    ans[stack.pop()] = 1;
                    ans[i] = 1;
                }
            }
        }
        int localMax =0,gloabalMax =0;
        for (Integer integer : ans) {
            if(integer == 1)
                localMax++;
            else if(integer == 0 )
            {
                gloabalMax = Math.max(localMax,gloabalMax);
                localMax = 0;
            }

        }
        if(localMax > gloabalMax)
            gloabalMax = localMax;
        return gloabalMax;

    }

}

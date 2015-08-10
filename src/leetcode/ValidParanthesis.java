package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 01/07/15
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Character temp  ;
        for(Character c:s.toCharArray())
        {
            if(c=='(' || c== '{'||c =='[')
                stack.push(c);
            if(c == ')')
            {
                temp = stack.pop();
                if(temp != '(')
                    return false;
            }

            if(c == '}')
            {
                temp = stack.pop();
                if(temp != '{')
                    return false;

            }

            if(c==']')
            {
                temp = stack.pop();
                if(temp != '[')
                    return false;

            }

        }
        if(stack.empty())
            return true;
        else
            return false;




    }
}

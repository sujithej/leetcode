import java.util.*;

/**
 * Created by sujith.j on 24/10/15.
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> ans = (new GenerateParenthesis()).generateParenthesis(10);
        System.out.println("hold");

    }

    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        List<String> ans =  new ArrayList<String>();
        String temp1 = "";
        Stack<StackObject> stack = new Stack<StackObject>();
        stack.push(new StackObject(left,right,temp1));
        StackObject stackObject;
        while(!stack.empty())
        {
            stackObject = stack.pop();
            temp1 = stackObject.str;
            left = stackObject.left;
            right = stackObject.right;
            if(left > 0)
            {
                stack.push(new StackObject(left-1,right,temp1+"("));
            }
            if(right > 0 && right > left)
            {
                stack.push(new StackObject(left,right-1,temp1+")"));
            }
            if(right ==0 && left == 0)
            {
                ans.add(temp1);
            }
        }
        return ans;
    }

    class StackObject
    {
        int left,right;
        String str;

        public StackObject(int left, int right, String str) {
            this.left = left;
            this.right = right;
            this.str = str;
        }
    }


    public void dfs(String parenthesis, int left, int right) {

    }


}

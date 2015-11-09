import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by sujith.j on 06/11/15.
 */
public class ValidBST {
    public static void main(String []args)
    {
        TreeNode tree = new TreeNode(5);
        System.out.println((new ValidBST()).isValidBST(tree));
    }

    public boolean isValidBST(TreeNode root) {
       List<Integer> inorderTraversal  = inorderTraversal(root);
        if(root == null)
            return true;
        Integer lasti = inorderTraversal.get(0);
        inorderTraversal.remove(lasti);
        for (Integer i : inorderTraversal) {
            if(i <= lasti)
                return false;
            else
                lasti = i;

        }
        return true;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        HashSet<TreeNode> traversed = new HashSet<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> inorderTraversal  = new ArrayList<Integer>();

        if(root == null)
            return inorderTraversal;
        traversed.add(root);
        if(root.right != null)
            stack.push(root.right);
        stack.push(root);
        if(root.left != null)
            stack.push(root.left);
        TreeNode temp;
        while(!stack.empty())
        {
            temp = stack.pop();
            if(traversed.contains(temp))
            {
                traversed.remove(temp);
                inorderTraversal.add(temp.val);
                continue;
            }
            else
            {
                traversed.add(temp);
                if(temp.right != null)
                    stack.push(temp.right);
                stack.push(temp);
                if(temp.left != null)
                    stack.push(temp.left);
            }

        }
        return inorderTraversal;

    }
}

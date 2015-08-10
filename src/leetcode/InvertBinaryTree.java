package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 22/06/15
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode temp = root;
        TreeNode temp1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(temp);
        while(!stack.empty())
        {
            temp = stack.pop();
            temp1 = temp.left;
            temp.left = temp.right;
            temp.right = temp1;
            if(temp.left != null)
                stack.push(temp.left);
            if(temp.right != null)
                stack.push(temp.right);

        }


        return root;

    }
}

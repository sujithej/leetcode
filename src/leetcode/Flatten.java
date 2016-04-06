import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sujith.j on 12/11/15.
 */
public class Flatten {
    public static void main(String []args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);

    }

    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode last = root;
        if(root == null)
            return ;
        if(root.left != null)
            queue.add(root.left);
        if(root.right != null)
            queue.add(root.right);
        TreeNode temp;
        while(!queue.isEmpty())
        {
            temp = queue.poll();
            last.right = temp;
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
            last = temp;
        }
        return;
    }

}

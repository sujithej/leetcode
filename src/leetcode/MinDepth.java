/**
 * Created by sujith.j on 08/11/15.
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null )
            return 0;
        return minDepthUtil(root);
    }

    public int minDepthUtil(TreeNode node)
    {

        if(node.left == null && node.right == null)
            return 1;
        else if(node.right != null && node.left == null)
            return minDepthUtil(node.right)+1;
        else if(node.left != null && node.right == null)
            return minDepthUtil(node.left)+1;
        else
            return Math.min(minDepthUtil(node.left),minDepthUtil(node.right))+1;

    }
}

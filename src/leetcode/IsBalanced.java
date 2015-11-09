/**
 * Created by sujith.j on 08/11/15.
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {

        heightTree(root);
        return isBalancedUtil(root);



    }
    public boolean isBalancedUtil(TreeNode node)
    {
        if(node == null || (node.left == null && node.right == null) )
            return true;
        if((node.left == null || node.right == null) && node.val > 2)
            return false;
        if((node.left == null || node.right == null) && node.val <= 2)
            return true;

        if(Math.abs(node.left.val - node.right.val) > 1 )
            return false;
        return isBalancedUtil(node.left) && isBalancedUtil(node.right);
    }



    public int heightTree(TreeNode treeNode)
    {
        if(treeNode == null)
            return 0;

        int height =  Math.max(heightTree(treeNode.left),heightTree((treeNode.right)))+1;
        treeNode.val = height;
        return height;

    }
}

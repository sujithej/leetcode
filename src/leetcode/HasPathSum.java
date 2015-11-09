/**
 * Created by sujith.j on 08/11/15.
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return  hasPathSumUtil(root,0,sum);
    }

    public boolean hasPathSumUtil(TreeNode node,int sum,int target)
    {

        if(node == null)
            return false;
        sum = sum +node.val;
        if(sum == target && node.left == null && node.right == null)
            return true;
        return hasPathSumUtil(node.left,sum,target) || hasPathSumUtil(node.right,sum,target);
    }
}

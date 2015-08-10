package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 12/07/15
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val < p.val && root.val > q.val)|| (root.val > p.val && root.val < q.val))
            return root;
        if(root.val < p.val)
            return lowestCommonAncestor(root.left,p,q);
        else
            return lowestCommonAncestor(root.right,p,q);
    }
}

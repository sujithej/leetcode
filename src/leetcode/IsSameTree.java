import java.util.Stack;

/**
 * Created by sujith.j on 07/11/15.
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<TreeNode>();
        Stack<TreeNode> qStack = new Stack<TreeNode>();
        pStack.push(p);
        qStack.push(q);
        TreeNode pTemp;
        TreeNode qTemp;



        while(!pStack.empty() && !qStack.empty())
        {
            pTemp = pStack.pop();
            qTemp = qStack.pop();
            if(pTemp ==null && qTemp == null)
                continue;
            if(pTemp ==null || qTemp == null || pTemp.val != qTemp.val)
                return false;

            pStack.push(pTemp.left);
            pStack.push(pTemp.right);
            qStack.push(qTemp.left);
            qStack.push(qTemp.right);
        }
        return true;
    }


}

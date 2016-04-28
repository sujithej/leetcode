import java.util.List;
import java.util.Stack;

public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pathP =new Stack<>();
        Stack<TreeNode> pathQ =new Stack<>();
        getPathUtil(root,p,pathP);
        getPathUtil(root,q,pathQ);
        TreeNode tempP = pathP.pop();
        TreeNode tempQ = pathQ.pop();
        TreeNode temp  = null;
        while(tempP == tempQ){
            temp = tempP;
            if(!pathP.empty())
                tempP   = pathP.pop();
            else
                tempP = null;
            if(!pathQ.empty())
                tempQ  = pathQ.pop();
            else
                tempP = null;
        }
        return temp;

    }

    public boolean getPathUtil(TreeNode root, TreeNode p,Stack<TreeNode> path){
        if(root == null)
            return false;
        if(root == p){
            path.push(root);
            return true;
        }
        if(getPathUtil(root.left,p,path)){
            path.push(root);
            return true;
        }
        if(getPathUtil(root.right,p,path)){
            path.push(root);
            return true;
        }
        return false;
    }

    public static void main(String []args){
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(7);
        p.left = q;
        TreeNode y = (new LowestCommonAncestor1()).lowestCommonAncestor(p,p,q);

    }
}

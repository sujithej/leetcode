import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sujith.j on 08/11/15.
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        pathSumUtil(root,0,sum,ans,temp);
        return ans;
    }

    public void pathSumUtil(TreeNode node,int sum,int target, List<List<Integer>> ans,List<Integer> track)
    {
        if(node == null)
            return;
        sum = sum +node.val;
        List<Integer> temp = new ArrayList<Integer>(track);
        temp.add(node.val);
        if(sum == target && node.left == null && node.right == null)
        {
            ans.add(temp);
        }
        pathSumUtil(node.left,sum,target,ans,temp);
        pathSumUtil(node.right,sum,target,ans,temp);
        return;
    }
}

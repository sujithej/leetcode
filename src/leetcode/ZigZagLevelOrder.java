package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 27/06/15
 * Time: 2:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        TreeNode temptreenode;

        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
        int i = 0;
        if(root == null)
            return ans;
        temp.add(root.val);
        ans.add(temp);
        temp = new ArrayList<Integer>();



        while(!s.empty())
        {

            temptreenode  = s.pop();
            if(isEven(i))
            {
                if(temptreenode.right != null)
                {
                    temp.add(temptreenode.right.val);
                    treeNodes.add(temptreenode.right);
                }

                if(temptreenode.left != null)
                {
                    temp.add(temptreenode.left.val);
                    treeNodes.add(temptreenode.left);

                }

            }
            else
            {
                if(temptreenode.left != null)
                {
                    temp.add(temptreenode.left.val);
                    treeNodes.add(temptreenode.left);
                }

                if(temptreenode.right != null)
                {
                    temp.add(temptreenode.right.val);
                    treeNodes.add(temptreenode.right);
                }

            }
            if(s.empty())
            {
                i+=1;
                for(TreeNode t:treeNodes)
                {
                    s.push(t);
                }
                if(temp.size() > 0)
                    ans.add(temp);
                temp = new ArrayList<Integer>();
                treeNodes = new ArrayList<TreeNode>();
            }

        }


        return ans;
    }

    public boolean isEven(int i)
    {
        return (i%2 == 0);
    }
}

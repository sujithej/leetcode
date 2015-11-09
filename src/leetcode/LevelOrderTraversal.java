import java.util.*;

/**
 * Created by sujith.j on 07/11/15.
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans  = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        int i = 0;
        if(root == null)
            return ans;
        queue1.add(root);
        TreeNode temp;

        ArrayList<Integer> levelList ;
        while(!queue1.isEmpty() || !queue2.isEmpty())
        {
            levelList = new ArrayList<>();
            if(isEven(i++))
            {

                while(!queue1.isEmpty())
                {
                    temp =queue1.poll();
                    levelList.add(temp.val);
                    if(temp.left !=null)
                        queue2.add(temp.left);
                    if(temp.right != null)
                        queue2.add(temp.right);
                }

            }
            else
            {
                while(!queue2.isEmpty())
                {
                    temp = queue2.poll();
                    levelList.add(temp.val);
                    if(temp.left != null)
                        queue1.add(temp.left);
                    if(temp.right != null)
                        queue1.add(temp.right);
                }

            }
            ans.add(levelList);
        }
        return ans;
    }

    public boolean isEven(int i)
    {
        return (i%2 == 0);
    }



}

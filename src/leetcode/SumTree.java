import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sujith.j on 08/04/16.
 */
public class SumTree {
        public int sumNumbers(TreeNode root) {
            //using BFS to solve this
            if(root == null)
                return 0;
            Deque<TreeNode> queue  = new LinkedList<TreeNode>();
            //constructing  a new tree
            TreeNode newRoot = new TreeNode(root.val);
            queue.add(root);
            queue.add(newRoot);
            TreeNode oldNode;
            TreeNode newNode;
            int sum = 0;
            while(!queue.isEmpty()){
                oldNode  = queue.poll();
                newNode = queue.poll();
                if(oldNode.left != null){
                    newNode.left = new TreeNode(newNode.val*10 + oldNode.left.val);
                    queue.add(oldNode.left);
                    queue.add(newNode.left);
                }
                if(oldNode.right != null){
                    newNode.right = new TreeNode(newNode.val*10 + oldNode.right.val);
                    queue.add(oldNode.right);
                    queue.add(newNode.right);
                }
                if(oldNode.left == null && oldNode.right == null){
                    sum += newNode.val;
                }
            }
            return sum;
        }

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(4);
        int sum = (new SumTree()).sumNumbers(root);
        System.out.println(sum);
    }
}

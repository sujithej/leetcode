import java.util.Deque;
import java.util.LinkedList;

public class MaxSumPath {
    public int maxPathSum(TreeNode root) {
        TreeNode newRoot = new TreeNode(root.val);
        if (root == null)
            return 0;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(newRoot);
        TreeNode oldNode;
        TreeNode newNode;
        while (!queue.isEmpty()) {
            oldNode = queue.poll();
            newNode = queue.poll();
            if (oldNode.left != null) {
                newNode.left = new TreeNode(oldNode.left.val);
                queue.add(oldNode.left);
                queue.add(newNode.left);
            }
            if (oldNode.right != null) {
                newNode.right = new TreeNode(oldNode.right.val);
                queue.add(oldNode.right);
                queue.add(newNode.right);
            }
        }
        maxSumUtil(newRoot);
        queue.add(root);
        queue.add(newRoot);
        int maxPath = root.val;
        int temp = 0;
        while (!queue.isEmpty()) {
            oldNode = queue.poll();
            newNode = queue.poll();
            temp = oldNode.val;
            if (newNode.left != null) {
                if (newNode.left.val > 0) {
                    temp += newNode.left.val;
                }
                queue.add(oldNode.left);
                queue.add(newNode.left);
            }
            if (oldNode.right != null) {
                if (newNode.right.val > 0) {
                    temp += newNode.right.val;
                }
                queue.add(oldNode.right);
                queue.add(newNode.right);
            }
            if (temp > maxPath) {
                maxPath = temp;
            }
        }

        return maxPath;
    }

    public int maxSumUtil(TreeNode node) {
        if (node == null)
            return 0;
        node.val = Math.max(Math.max(maxSumUtil(node.left), maxSumUtil((node.right))) + node.val, node.val);
        return node.val;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(-1);
        int sum = (new MaxSumPath()).maxPathSum(root);
        System.out.println(sum);
    }
}

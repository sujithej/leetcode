/**
 * Created by sujith.j on 07/11/15.
 */
public class BuildTreePostOrder {
    /**
     * Created by sujith.j on 07/11/15.
     */


    public static void main(String[] args) {
        int[] postorder = {2, 1};
        int[] inorder = {1, 2};
        TreeNode root = (new BuildTreePostOrder()).buildTree(inorder, postorder);
        System.out.println("hold");

    }

    public TreeNode buildTree(int[] inorder, int[] postOrder) {

        int length = inorder.length;
        if (length == 0)
            return null;
        return buildTreeUtil(inorder, postOrder, 0, length - 1, 0, length - 1);
    }


    public TreeNode buildTreeUtil(int[] inorder, int[] postorder, int startInorder, int stopInorder, int startPostorder, int stopPostorder) {
        if (startInorder > stopInorder)
            return null;
        if (stopPostorder < startPostorder)
            return null;

        int inOrderpivot = stopInorder;
        while(inorder[inOrderpivot] != postorder[stopPostorder])
            inOrderpivot--;
        int postOrderpivot = stopPostorder -(stopInorder-inOrderpivot);
        TreeNode node = new TreeNode(postorder[stopPostorder]);
        node.left = buildTreeUtil(inorder,postorder,startInorder,inOrderpivot-1,startPostorder,postOrderpivot-1);
        node.right = buildTreeUtil(inorder,postorder,inOrderpivot+1,stopInorder,postOrderpivot,stopPostorder-1);
        return node;
    }
}

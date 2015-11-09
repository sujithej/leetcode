/**
 * Created by sujith.j on 07/11/15.
 */
public class BuildTreePreOrder {

    public static void main(String []args)
    {
        int []inorder= {1,2};
        int []preorder = {1,2};
        TreeNode root = (new BuildTreePreOrder()).buildTree(preorder,inorder);
        System.out.println("hold");

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int length = preorder.length;
        if(length == 0)
            return null;
        return buildTreeUtil(preorder,inorder,0,length-1,0,length-1);
    }


    public TreeNode buildTreeUtil(int []preorder,int []inorder,int startPreorder,int stopPreorder,int startInorder,int stopInorder)
    {
        if(startPreorder > stopPreorder)
            return null;
        if(stopInorder < startInorder)
            return null;

        int inorderPivot = startInorder;
        if(preorder.length != inorder.length)
            System.out.println("something went wrong");
        while(inorder[inorderPivot] != preorder[startPreorder])
            inorderPivot++;
        TreeNode node = new TreeNode(inorder[inorderPivot]);
        int preOrderPivot  = startPreorder+(inorderPivot - startInorder);
        node.left = buildTreeUtil(preorder, inorder, startPreorder + 1, preOrderPivot, startInorder, inorderPivot-1);
        node.right = buildTreeUtil(preorder,inorder,preOrderPivot+1,stopPreorder,inorderPivot+1,stopInorder);
        return node;

    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujith.j on 06/11/15.
 */
public class GenerateTrees {

    public static void main(String []args)
    {
        List<TreeNode> ans = (new GenerateTrees()).generateTrees(3);
        System.out.println("hold");
    }


    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> [][]trees = (ArrayList<TreeNode>[][])new ArrayList[n+1][n+1];
        return generateTreesUtil(trees,1,n);

    }


    public  List<TreeNode> generateTreesUtil(List<TreeNode> [][]trees,int start ,int end)
    {


        if(start > end) {
            TreeNode blank = null;
            List<TreeNode> blankList = new ArrayList<TreeNode>();
            blankList.add(blank);
            return (blankList);
        }

        if(trees[start][end] != null)
            return trees[start][end];

        if(start == end)
        {
            List<TreeNode> temp1 = new ArrayList<TreeNode>();
            temp1.add(new TreeNode(start));
            return temp1;
        }

        List<TreeNode> treeNodes = new ArrayList<TreeNode>();


        for(int i= start; i<= end;i++)
        {
            List<TreeNode> leftNodes = generateTreesUtil(trees,start,i-1);
            List<TreeNode> rightNodes = generateTreesUtil(trees,i+1,end);
            treeNodes.addAll(addTreeNodes(leftNodes, rightNodes, i));
        }

        trees[start][end] = treeNodes;
        return treeNodes;
    }



    public List<TreeNode>  addTreeNodes(List<TreeNode> left,List<TreeNode>  right,int root)
    {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        for (TreeNode leftTree : left) {
            for (TreeNode rightTree : right) {
                TreeNode rootNode = new TreeNode(root);
                rootNode.left = leftTree;
                rootNode.right = rightTree;
                ans.add(rootNode);
            }
        }

        return ans;

    }
}

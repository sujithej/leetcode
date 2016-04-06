import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sujith.j on 12/11/15.
 */


class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }


public class Connect {

    public static void main(String []args)
    {
        TreeLinkNode a = (new TreeLinkNode(5));
        a.left = (new TreeLinkNode(4));
        a.right = (new TreeLinkNode(6));
        (new Connect()).connect(a);
        System.out.println("hold");
    }



    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> queue2 = new LinkedList<TreeLinkNode>();
        int i = 0;
        if(root == null)
            return;
        queue1.add(root);
        TreeLinkNode temp;
        TreeLinkNode temp1;


        while(!queue1.isEmpty() || !queue2.isEmpty())
        {

            if(isEven(i++))
            {
                temp =queue1.poll();
                if(temp.left !=null)
                    queue2.add(temp.left);
                if(temp.right != null)
                    queue2.add(temp.right);

                while(!queue1.isEmpty())
                {
                    temp1 =queue1.poll();
                    if(temp1.left !=null)
                        queue2.add(temp1.left);
                    if(temp1.right != null)
                        queue2.add(temp1.right);
                    temp.next = temp1;
                    temp = temp1;
                }

            }
            else
            {
                temp = queue2.poll();
                if(temp.left != null)
                    queue1.add(temp.left);
                if(temp.right != null)
                    queue1.add(temp.right);
                while(!queue2.isEmpty())
                {
                    temp1 = queue2.poll();
                    if(temp1.left != null)
                        queue1.add(temp1.left);
                    if(temp1.right != null)
                        queue1.add(temp1.right);
                    temp.next = temp1;
                    temp = temp1;
                }

            }
        }
        return ;

    }



    public boolean isEven(int i)
    {
        return (i%2 == 0);
    }

}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujith.j on 17/11/15.
 */
public class PascalTriangle {
    public static void main(String []args)
    {
        for(int i = 0;i<6;i++ )
        {
            List<List<Integer>> generate = (new PascalTriangle()).generate(i);
            System.out.println("hold");
        }
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if(numRows == 0)
            return ans;
        temp.add(1);
        ans.add(temp);
        List<Integer> temp1 = new ArrayList<Integer>();

        for(int i=0 ;i < numRows-1;i++)
        {

            temp1 = new ArrayList<Integer>();
            temp1.add(1);
            for(int j =0 ;j < i;j++)
            {
                temp1.add(temp.get(j) + temp.get(j+1));
            }
            temp1.add(1);
            temp = temp1;
            ans.add(temp);
        }
        return ans;
    }
}

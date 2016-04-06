import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujith.j on 17/11/15.
 */
public class PascalTriangle2 {


    public static void main(String[] args) {
        for(int i = 0;i<6;i++ )
        {
            List<Integer> generate = (new PascalTriangle2()).getRow(i);
            System.out.println("hold");
        }

    }


    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> temp1;
        if(rowIndex == 0)
            return temp;
        temp.add(1);
        for(int i=0 ;i < rowIndex-1;i++)
        {

            temp1 = new ArrayList<Integer>();
            temp1.add(1);
            for(int j =0 ;j < i;j++)
            {
                temp1.add(temp.get(j) + temp.get(j+1));
            }
            temp1.add(1);
            temp = temp1;
        }
        return temp;
    }

}

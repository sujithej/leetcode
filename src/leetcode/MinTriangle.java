import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sujith.j on 17/11/15.
 */
public class MinTriangle {
    public static void main(String []args)
    {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        Integer []row1 = {1};
        triangle.add(new ArrayList<Integer>(Arrays.asList(row1)));
        Integer []row2 = {1,2};
        triangle.add(new ArrayList<Integer>(Arrays.asList(row2)));
        Integer []row3 = {5,1,5};
        triangle.add(new ArrayList<Integer>(Arrays.asList(row3)));
        Integer []row4 = {5,1,5,7};
        triangle.add(new ArrayList<Integer>(Arrays.asList(row4)));
        int best = (new MinTriangle()).minimumTotal(triangle);
        System.out.println(best);

    }



    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> localBest = new ArrayList<Integer>();
        if(triangle.size() == 0)
            return 0;
        localBest = triangle.get(0);
        List<Integer> row;
        int startBest;
        int endBest;
        int lastBest;
        int temp;

        for (int i = 1; i < triangle.size(); i++) {
            row = triangle.get(i);
            startBest = localBest.get(0);
            endBest = localBest.get(i-1);
            lastBest = startBest;

            for(int j = 1;j<i;j++)
            {
                temp = localBest.get(j);
                localBest.set(j,Math.min(lastBest,temp)+row.get(j));
                lastBest = temp;
            }
            localBest.set(0,startBest+row.get(0));
            localBest.add(endBest + row.get(i));
        }
        int best = localBest.get(0);
        for (Integer integer : localBest) {
            if(integer < best)
                best = integer;
        }
        return best;

    }
}

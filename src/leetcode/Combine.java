import java.util.*;

/**
 * Created by sujith.j on 28/10/15.
 */
public class Combine {
    public static void main(String []args)
    {
        List<List<Integer>> combine = (new Combine()).combine(4,2);
        System.out.println("hold");


    }


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int []temp = new int[k];
        combUtil(ans,1,n,temp,0,k);
//        HashSet<List<Integer>> unique = new HashSet<List<Integer>>(ans);
        return ans;

    }

    public void combUtil(List<List<Integer>> ans,int start,int end,int []temp,int index,int k)
    {
        if(index == k)
        {
            ans.add(convertArrayToList(temp));
            return;
        }
        int terminate = end - (k-index)+1;
        for(int i=start;i<=end && i <= terminate;i++ ) {
            temp[index] = i;
            combUtil(ans,i+1,end,temp,index+1,k);

        }


    }

    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }


}

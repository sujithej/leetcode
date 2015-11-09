/**
 * Created by sujith.j on 28/10/15.
 */
public class SearchMatrix {
    public static void main(String []args)
    {
//        (new SearchMatrix())
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m*n -1;
        int mid;
        int i,j;
        while(start < end)
        {
            mid = start + (end-start)/2;
            i = mid/n;
            j = mid%n;
            if(matrix[i][j] == target )
                return true;
            if(matrix[i][j] > target)
                end = mid -1;
            else
                start = mid+1;


        }

        return false;

    }
}

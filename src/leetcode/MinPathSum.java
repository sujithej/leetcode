/**
 * Created by sujith.j on 27/10/15.
 */
public class MinPathSum {
    public  static void main(String []args)
    {
        int [][]grid = {{0,0,0},{0,1,0}};
        System.out.println((new MinPathSum()).minPathSum(grid));


    }

    public int minPathSum(int[][] grid) {
        if(grid.length ==0 )
            return 0;
        int [][]countGrid = new int[grid.length][grid[0].length];
        countGrid[0][0] = grid[0][0];
        int m= grid.length;
        int n = grid[0].length;
        for(int i=1;i<m;i++)
        {

                countGrid[i][0] = countGrid[i-1][0] + grid[i][0];
        }
        for(int j=1 ;j<n ;j++)
        {

                countGrid[0][j] = countGrid[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1 ;j<n ;j++)
            {

                    countGrid[i][j] = Math.min(countGrid[i-1][j], countGrid[i][j-1]) +grid[i][j];
            }

        }
        return countGrid[m-1][n-1];

    }
}

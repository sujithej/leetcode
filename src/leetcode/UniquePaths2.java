/**
 * Created by sujith.j on 27/10/15.
 */
public class UniquePaths2 {
    public  static void main(String []args)
    {
        int [][]grid = {{0,0,0},{0,1,0}};
        System.out.println((new UniquePaths2()).uniquePathsWithObstacles(grid));


    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length ==0 || obstacleGrid[0][0] == 1)
            return 0;
        int [][]countGrid = new int[obstacleGrid.length][obstacleGrid[0].length];
        countGrid[0][0] = 1;
        int m= obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for(int i=1;i<m;i++)
        {
            if(obstacleGrid[i][0] == 0)
                countGrid[i][0] = countGrid[i-1][0];
        }
        for(int j=1 ;j<n ;j++)
        {
            if(obstacleGrid[0][j] == 0)
                countGrid[0][j] = countGrid[0][j-1];
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1 ;j<n ;j++)
            {
                if(obstacleGrid[i][j] == 0)
                    countGrid[i][j] = countGrid[i-1][j] + countGrid[i][j-1];
            }

        }
        return countGrid[m-1][n-1];

    }
}

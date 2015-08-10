package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 08/08/15
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumIslands {
    public static void main(String []args)
    {
        int count ;
        char [][]grid = {{'1','1','1','0','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','1'},
                         {'0','0','0','1','0'}};
        count  = (new  NumIslands()).numIslands(grid);
        System.out.println(count);
    }




    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i=0;i<grid.length; i++ )
        {
            for(int j = 0; j < grid[0].length;j++)
            {
                if(grid[i][j] == '1')
                {
                    markTraversed(grid,i,j);
                    count++;
                }
            }
        }
        return count;

    }

    public void markTraversed(char [][]grid,int x, int y)
    {
        Deque<Pos> deque = new LinkedList<Pos>();
        Pos temp;
        int maxXIndex = grid.length -1;
        int maxYIndex = grid[0].length - 1;
        int nextXindex,nextYIndex;
        deque.add(new Pos(x,y));
        while(deque.size() != 0)
        {
            temp = deque.pop();
            grid[temp.x][temp.y] = '2';
            nextXindex = Math.max(temp.x - 1, 0);
            nextYIndex = temp.y;
            if(grid[nextXindex][nextYIndex] == '1')
                deque.add(new Pos(nextXindex,nextYIndex));
            nextXindex = Math.min(temp.x + 1, maxXIndex);
            nextYIndex = temp.y;
            if(grid[nextXindex][nextYIndex] == '1')
                deque.add(new Pos(nextXindex,nextYIndex));
            nextXindex = temp.x;
            nextYIndex = Math.min(temp.y + 1, maxYIndex);
            if(grid[nextXindex][nextYIndex] == '1')
                deque.add(new Pos(nextXindex,nextYIndex));
            nextXindex = temp.x;
            nextYIndex = Math.max(temp.y - 1,0);
            if(grid[nextXindex][nextYIndex] == '1')
                deque.add(new Pos(nextXindex,nextYIndex));

        }


    }


    class Pos
    {
        int x,y;
        Pos(int x,int y)
        {
            this.x = x;
            this.y = y;
        }


    }

}

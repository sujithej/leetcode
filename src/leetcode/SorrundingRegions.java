package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 09/08/15
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class SorrundingRegions {
    public static void main(String []args)
    {
        char [][]board = {{'0'}};
        (new SorrundingRegions()).solve(board);
        System.out.println("hold");
    }

    public void solve(char[][] board) {
        if(board == null || board.length==0)
            return;

        System.out.println(board[0].length);


        for(int j=0;j<board[0].length;j++)
        {
            merge(board,0,j);
            merge(board,board.length-1,j);
        }

        for(int i=0;i<board.length;i++)
        {
            merge(board,i,0);
            merge(board,i,board[0].length-1);
        }

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '1')
                    board[i][j] = 'O';


            }

        }


    }

    public void merge(char[][]board,int i,int j)
    {
        if(i<0 || j< 0 || i>= board.length||j>=board[0].length)
            return;

        if(board[i][j] == 'O')
            board[i][j] = '1';
        else
            return;

        merge(board,i-1,j);
        merge(board,i+1,j);
        merge(board,i,j-1);
        merge(board,i,j+1);



    }

}

import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by sujith.j on 31/10/15.
 */
public class WordSearch {
    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char [][]board2  = {{'a','a'}};

        System.out.println((new WordSearch()).exist(board2,"aaa"));

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] traversed = new boolean[m][n];
        boolean temp = false;
        char[] wordArray = word.toCharArray();
//        return existUtil(board, traversed, wordArray, 0, 0, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (existUtil(board, traversed, wordArray, 0, i, j))
                    return true;
        }
        return false;


    }


    public boolean existUtil(char[][] board, boolean[][] traversed, char[] word, int index, int i, int j) {
        if (index == word.length-1 && board[i][j] == word[index] && traversed[i][j] == false)
            return true;

        int m = board.length;
        int n = board[0].length;

        if (board[i][j] != word[index] || traversed[i][j] == true)
            return false;
        else
            traversed[i][j] = true;

        boolean flag = false;

        if (i != 0 && existUtil(board, traversed, word, index + 1, i - 1, j))
            flag = true;
        if (j != 0 && existUtil(board, traversed, word, index + 1, i, j - 1))
            flag = true;
        if (i != m - 1 && existUtil(board, traversed, word, index + 1, i + 1, j))
            flag = true;
        if (j != n - 1 && existUtil(board, traversed, word, index + 1, i , j+1))
            flag = true;

        if (flag == false)
            traversed[i][j] = false;
        return flag;

    }


}

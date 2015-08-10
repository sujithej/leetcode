package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 05/07/15
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidSuduko {
    public static void main(String[] args) {
        char [][]board = {{'.', '8', '7', '6', '5', '4', '3', '2', '1'}, {'2', '.', '.', '.', '.', '.', '.', '.', '.'}, {'3', '.', '.', '.', '.', '.', '.', '.', '.'}, {'4', '.', '.', '.', '.', '.', '.', '.', '.'}, {'5', '.', '.', '.', '.', '.', '.', '.', '.'}, {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        boolean isValid = (new ValidSuduko()).isValidSudoku(board);
        System.out.println(isValid);
    }


    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            if (!evaluateRow(board, i))
                return false;
        }

        for (int j = 0; j < 9; j++) {
            if (!evaluateColumn(board, j))
                return false;
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!evaluateMatrix(board, i, j))
                    return false;
            }


        }
        return true;


    }

    public boolean evaluateRow(char[][] board, int column) {
        int[] arr = new int[10];
        int temp;


        for (int i = 0; i < 9; i++) {
            temp = board[i][column] - 48;

            if (temp > 0 && temp < 10) {
//                System.out.println(temp);

                if (arr[temp] == 1)
                    return false;
                else
                    arr[temp] = 1;
            }

        }
        return true;

    }

    public boolean evaluateColumn(char[][] board, int row) {
        int[] arr = new int[10];
        int temp;
        for (int i = 0; i < 9; i++) {
            temp = board[row][i] - 48;
            if (temp > 0 && temp < 10) {

                if (arr[temp] == 1)
                    return false;
                else
                    arr[temp] = 1;
            }

        }
        return true;

    }

    public boolean evaluateMatrix(char[][] board, int rowstart, int columnstart) {
        int[] arr = new int[10];
        int temp;
        for (int i = rowstart; i < rowstart + 3; i++) {
            for (int j = columnstart; j < columnstart+3; j++) {
                temp = board[i][j] - 48;
//                System.out.println(temp);
                if (temp > 0 && temp < 10) {

                    if (arr[temp] == 1)
                        return false;
                    else
                        arr[temp] = 1;
                }

            }
        }
        return true;

    }


}

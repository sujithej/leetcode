import java.util.*;

/**
 * Created by sujith.j on 25/10/15.
 */
public class SpiralOrder {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0;
        int y = 0;
        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[x++][y]);
                }
                break;
            }

            //below, process a circle

            //top - move right
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y++]);
            }

            //right - move down
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x++][y]);
            }

            //bottom - move left
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y--]);
            }

            //left - move up
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            m = m - 2;
            n = n - 2;
        }

        return result;
    }


}

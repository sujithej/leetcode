import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujith.j on 19/04/16.
 */
public class NQueens2 {
        int solutions = 0;

        public int totalNQueens(int n) {
            int[] position = new int[n + 1];

            positionUtil(position,1);
            return solutions;
        }


        public void positionUtil(int[] position, int column) {
            if (column == position.length) {
                solutions += 1;
                return;
            }

            for (int i = 1; i < position.length; i++) {
                position[column] = i;
                if (isSafe(position, column)) {
                    positionUtil(position, column + 1);
                }

            }
            position[column] = 0;
        }


        public List<String> parsePostion(int[] position) {
            List<String> solution = new ArrayList<>();
            for (int i = 1; i < position.length; i ++ ){
                StringBuilder temp = new StringBuilder();
                for(int j = 1 ; j < position[i] ; j++){
                    temp.append(".");
                }
                temp.append("Q");
                for(int j =  position[i] + 1 ; j < position.length ; j++){
                    temp.append(".");
                }
                solution.add(temp.toString());
            }
            return solution;

        }

        public boolean isSafe(int[] position, int column) {
            for (int i = 1; i <= column; i++) {
                for (int j = i + 1; j <= column; j++) {
                    if (position[i] == position[j])
                        return false;
                    if (Math.abs(position[i] - position[j]) == Math.abs(i - j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static void main(String []args){
            int nQueens = (new NQueens2()).totalNQueens(4);
            System.out.println(nQueens);

        }



}

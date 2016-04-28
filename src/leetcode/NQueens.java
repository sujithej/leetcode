import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[] position = new int[n + 1];
        List<List<String>> solutions = new ArrayList<>();
        positionUtil(position,solutions,1);
        return solutions;
    }


    public void positionUtil(int[] position, List<List<String>> solutions, int column) {
        if (column == position.length) {
            solutions.add(parsePostion(position));
            return;
        }

        for (int i = 1; i < position.length; i++) {
            position[column] = i;
            if (isSafe(position, column)) {
                positionUtil(position, solutions, column + 1);
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
        List<List<String>> nQueens = (new NQueens()).solveNQueens(4);
        System.out.println("hold");

    }


}

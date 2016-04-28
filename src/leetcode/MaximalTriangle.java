public class MaximalTriangle {
    public int maximalRectangle(char[][] matrix) {
        int rowLenght = matrix.length;
        if (rowLenght == 0)
            return 0;
        int columnLength = matrix[0].length;

        int[][] counts = new int[rowLenght][columnLength];
        int temp = 0;
        for (int i = 0; i < rowLenght; i++) {
            temp = 0;
            for (int j = 0; j < columnLength; j++) {
                if (matrix[i][j] == '1') {
                    temp++;
                    counts[i][j] = temp;
                } else {
                    temp = 0;
                }
            }
        }

        int maxArea = 0;
        int area = 0;
        for (int startColumn = 0; startColumn < columnLength; startColumn++) {
            for (int endColumn = startColumn; endColumn < columnLength; endColumn++) {
                temp = 0;
                int length = endColumn - startColumn + 1;
                for (int i = 0; i < rowLenght; i++) {
                    if (counts[i][endColumn] >= length) {
                        temp++;
                    } else {
                        area = length * temp;
                        if (area > maxArea) {
                            maxArea = area;
                        }
                        temp = 0;
                    }
                }
                area = length * temp;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char [][]maximalRectangle = {{'1','1'}};
        int maxArea = (new MaximalTriangle()).maximalRectangle(maximalRectangle);
        System.out.println(maxArea);

    }
}

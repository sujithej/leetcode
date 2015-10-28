/**
 * Created by sujith.j on 25/10/15.
 */
import java.util.*;

public class RotateImage {
//    You are given an n x n 2D matrix representing an image.
//
//    Rotate the image by 90 degrees (clockwise).
    public static void main(String []args)
    {
        int [][]matrix = {
                {01,02,03,04},
                {11,12,13,14},
                {21,22,23,24},
                {31,32,33,34}};
        (new RotateImage()).rotate(matrix);
        System.out.println("hold");

    }

    public void rotate(int[][] matrix) {
        int temp1,temp2;
        int n = matrix.length;
        for(int i=0;i<n ; i++)
            for(int j=i;j < n-(i+1);j++)
            {
                temp1 = matrix[j][n-(i+1)];
                matrix[j][n-(i+1)] = matrix[i][j];
                temp2 = matrix[n-(i+1)][n-(j+1)];
                matrix[n-(i+1)][n-(j+1)] = temp1;
                temp1 = matrix[n-(j+1)][i];
                matrix[n-(j+1)][i] = temp2;
                matrix[i][j] = temp1;
            }
    }
}

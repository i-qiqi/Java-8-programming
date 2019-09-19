package algo;

import java.util.Arrays;
import java.util.Collections;

public class T48MatrixRotate1 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len/2; ++i){
            int start = i, end = len - i - 1;
            for(int j = 0; j < end - start; ++j){
                int tmp = matrix[start][start+j];
                matrix[start][start+j] = matrix[end-j][start];
                matrix[end-j][start] = matrix[end][end-j];
                matrix[end][end-j] = matrix[start+j][end];
                matrix[start+j][end] = tmp;
            }
        }
    }

    public void rotate_0(int[][] matrix){
        int n = matrix.length;
        //transpose
        for(int i = 0; i < n ; ++i){
            for(int j = i; j < n ; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //reverse each row
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}

package swordoffer;

import java.util.ArrayList;

public class MatrixPrinter {
    public  static  void main(String args[]){
        int[][] matrix0 = new int[3][5];
        int[][] matrix1 = new int[3][1];
        int[][] matrix2 = new int[1][5];
        fillMatrix(matrix0);
        System.out.println(printMatrix(matrix0));
        fillMatrix(matrix1);
        System.out.println(printMatrix(matrix1));
        fillMatrix(matrix2);
        System.out.println(printMatrix(matrix2));

    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int r1 = 0 , r2 = matrix.length -1 , c1 = 0 , c2 = matrix[0].length - 1;
        while(r1 <= r2 && c1 <= c2){
            //上
            for(int i = c1; i <= c2; i++){
                ans.add(matrix[r1][i]);
            }
            //右
            for(int i = r1 + 1; i <= r2; i++){
                ans.add(matrix[i][c2]);
            }
            //下
            for(int i = c2 - 1; i >= c1 && r1 < r2; i--){
                ans.add(matrix[r2][i]);
            }
            //左
            for(int i = r2 - 1; i > r1 && c1 < c2; i--){
                ans.add(matrix[i][c1]);
            }
            r1++;r2--;c1++;c2--;
        }
        return ans;
    }

    public static void fillMatrix(int [][] matrix) {
        int r1 = 0 , r2 = matrix.length -1 , c1 = 0 , c2 = matrix[0].length - 1;
        int cnt = 1;
        while(r1 <= r2 && c1 <= c2){
            //上
            for(int i = c1; i <= c2; i++){
                matrix[r1][i] = cnt++;
            }
            //右
            for(int i = r1 + 1; i <= r2; i++){
                matrix[i][c2]= cnt++;
            }
            //下
            for(int i = c2 - 1; i >= c1 && r1 < r2; i--){
                matrix[r2][i]= cnt++;
            }
            //左
            for(int i = r2 - 1; i > r1 && c1 < c2; i--){
                matrix[i][c1]= cnt++;
            }
            r1++;r2--;c1++;c2--;
        }
    }
}

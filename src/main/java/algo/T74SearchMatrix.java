package algo;

public class T74SearchMatrix{
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n -1;
        int mid = 0 , i = 0 , j = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            i = mid / n;
            j = mid % n;
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return false;
    }
}
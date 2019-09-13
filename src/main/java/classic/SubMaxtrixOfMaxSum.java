package classic;

public class SubMaxtrixOfMaxSum{
    public int maxSum(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int mx = Integer.MIN_VALUE;
        int tmp_sum = 0;
        int[] s = null;
        for(int i = 0; i < m; ++i){
            s = new int[n];
            for(int j = i; j < m; ++j){
                tmp_sum = 0; //置0
                for(int k = 0; k < n; ++k){
                    s[k] += matrix[j][k];
                    tmp_sum += s[k];
                    mx = Math.max(mx, tmp_sum);
                    tmp_sum = tmp_sum < 0 ? 0 : tmp_sum;
                }
            }
        }
        return mx;
    }

    public static void main(String[] args){
        int[][] matrix = {
            {-90,48,78},
            {64,-40,64},
            {-81,-7,66}
        };
        System.out.println(new SubMaxtrixOfMaxSum().maxSum(matrix));
    }
}
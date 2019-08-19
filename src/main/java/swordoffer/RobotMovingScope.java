package swordoffer;

public class RobotMovingScope {
    final int[][] next = {{0,-1},{0,1},{1,0},{-1,0}};
    int rows , cols;
    int threshold;
    int[][] digitSum;

    int ans = 0;


    void initDigitSum(){
        int[] digitSumOne = new int[Math.max(rows,cols)];
        for(int i = 0; i < digitSumOne.length ; i++){
            int n = i;
            while(n > 0){
                digitSumOne[i] += n % 10;
                n = n / 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0; j < cols ; j++){
                this.digitSum[i][j] = digitSumOne[i]+digitSumOne[j];
            }
        }
    }

    void dfs(boolean[][] marked , int r , int c){
        //剪枝条件
        if(r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) return;

        //do mark
        marked[r][c] = true;


        //边界处理
        if(this.digitSum[r][c] > this.threshold) return;

        this.ans++;

       for(int[] d : next){
           //递归
           dfs(marked , r + d[0] , c + d[1]);
       }
    }

    void dfs_1(boolean[][] marked , int r , int c){

        //do mark
        marked[r][c] = true;
        //边界条件
        if(this.digitSum[r][c] > this.threshold){
            return;
        }else{
            this.ans++;
        }
        for(int[] d : next){
            //剪枝条件
            int next_r = r + d[0] , next_c = c + d[1];
            if((next_r >= 0 && next_r < rows) && (next_c >= 0 && next_c < cols) && !marked[next_r][next_c]){
                //递归
                dfs(marked , next_r ,next_c);
            }
        }
    }

    public int movingCount(int threshold , int rows , int cols){
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked , 0 , 0);
        return this.ans;
    }
}

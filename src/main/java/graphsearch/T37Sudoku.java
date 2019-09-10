package graphsearch;

public class T37Sudoku{
    //box size
    int n = 3;
    int N = n*n;
    int[][] rows = new int[N][N+1];
    int[][] columns = new int[N][N+1];
    int[][] boxes = new int[N][N+1];
    char[][] board;

    boolean sudukuSolved = false;

    /**
     * 约束编程
     * Check if one could place a number d in (row , col) cell
     * @param d
     * @param row
     * @param col
     * @return
     */
    public boolean couldPlace(int d, int row, int col){
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    /**
     * Place a number d in (row , col) cell
     * @param d
     * @param row
     * @param col
     */
    public void placeNumber(int d, int row, int col){
        int idx = (row / n) * n + col / n;
        rows[row][d] = 1;
        columns[col][d] = 1;
        boxes[idx][d] = 1;
        board[row][col] = (char)(d + '0');
    }

    public void placeNextNumbers(int row, int col){
        if((col == N - 1) && (row == N - 1)){
            sudukuSolved = true;
        }else{
            if(col == N - 1){
                backtrack(row + 1, 0); //如果在行尾，就尝试下一行
            }else{
                backtrack(row, col + 1);
            }
        }
    }

    public void removeNumber(int d, int row, int col){
        int idx = (row / n) * n + col / n;
        rows[row][d] = 0;
        columns[col][d] = 0;
        boxes[idx][d] = 0;
        board[row][col] = '.'; 
    }

    /**
     * 回溯
     * @param row
     * @param col
     */
    public void backtrack(int row, int col){
        if(board[row][col] == '.'){
            for(int d = 1; d < 10; d++){
                if(couldPlace(d, row , col)){
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    //如果已解决，则没有必要回溯
                    if(!sudukuSolved) removeNumber(d, row, col);
                }
            }
        }else{
            placeNextNumbers(row , col);
        }
    }

    public void solveSudoku(char[][] board){
        this.board = board;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                char num = board[i][j];
                if(num != '.'){
                    int d = Character.getNumericValue(num);
                    placeNumber(d , i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    public void print(){
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        T37Sudoku t37Soudu = new T37Sudoku();
        char[][] board = { 
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        for(int i = 0 ; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = '.';
            }
        }
    
        t37Soudu.solveSudoku(board);
        t37Soudu.print();
    }

}
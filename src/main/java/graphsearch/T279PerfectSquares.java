package graphsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T279PerfectSquares {
    public int numSquares_dp(int n){
        int[] dp = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            dp[i] = i;
            for(int j = 1; i - j * j >= 0; j++){
                dp[i] = Math.min(dp[i] , dp[i-j*j]+1); 
            }
        }
        return dp[n];
    }

    public int numSquares(int n){
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n+1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            while(size-- > 0){
                int cur = queue.poll();
                for(int s : squares){
                    int next = cur - s;
                    if(next < 0) break;
                    if(next == 0) return level;
                    if(marked[next]) continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    private List<Integer> generateSquares(int n){
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while(square <= n){
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

}
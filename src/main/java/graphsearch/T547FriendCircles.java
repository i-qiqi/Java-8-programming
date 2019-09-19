package graphsearch;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class T547FriendCircles {
    public int findCircleNum(int[][] M){
        int n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for(int i = 0; i < n ; i++){
            if(!hasVisited[i]){
                dfs(M , i , hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M , int i, boolean[] hasVisited){
        hasVisited[i] = true;
        for(int k = 0; k < M.length ; k++){
            if(M[i][k] == 1 && !hasVisited[k]){
                dfs(M , k, hasVisited);
            }
        }
    }     
    
    int ans = 0;
    public void dfs(int[][] values , boolean[] used, int cnt , int minX , int minY ){
        for(int i = 0; i < values.length; i++){
            if(used[i]){
                continue;
            }
            if(values[i][0] < minX || values[i][1] < minY){
                continue ;
            }
            ans = Math.max(ans , cnt+1);
            used[i] = true;
            dfs(values , used , cnt + 1, values[i][0] , values[i][1]);
            used[i] = false;
        }
    }
   public static void main(String args[]){
    //    Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt();
       int n =4;
       int[][] values = {
           {3,2},
           {1,1},
           {1,3},
           {2,2}
       };

        Arrays.sort(values, (o1, o2) -> {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o1[1] - o2[1];
            }   
        });
       int[] dp = new int[n];
       dp[0] = 1;
       for(int i = 1; i < n; i++){
           int pre = -1;
           for(int k = i-1; k >= 0 ; k--){
               if(values[k][0] <= values[i][0] && values[k][1] <= values[i][1]){
                    pre = k;
                    break;
               }
           }
           dp[i] = (pre == -1) ? dp[i-1] : Math.max(dp[i-1] , dp[pre] + 1);
       } 
       System.out.println(dp[n-1]);
    }

   public static void main_2(String args[]){

   }
   public static void main_1(String args[]){
    Scanner sc = new Scanner(System.in);
    // String s = sc.nextLine();
    String s = "a<<b((c)<)";
    Stack<Character> stack = new Stack();
    for(int i = 0 ; i < s.length(); i++){
        char c = s.charAt(i);
        if(c == '<'){
            if(!stack.empty() && stack.peek() != '('){
                stack.pop();
            } 
        }else if(c == ')'){
            while(!stack.empty()){
                char cur = stack.peek();
                stack.pop();
                if(cur == '(') break;
            }
        }else{
            stack.push(c);
        }
    }
  

    String ans = "";
    while(!stack.isEmpty()){
        ans = stack.pop() + ans;
    }
    System.out.println(ans);
}
}
package algo;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {

    public int[][] getNearLessNoRepeat(int[] arr){
        if(arr == null || arr.length == 0) return null;
        int n = arr.length;
        int[][] ans = new int[n][2];
        Stack<Integer> asc_stack = new Stack<>();
        for(int i = 0; i < n ; i++){
            while(!asc_stack.isEmpty() && arr[asc_stack.peek()] > arr[i]){
                ans[asc_stack.peek()][1] = i;
                asc_stack.pop();
            }
            asc_stack.push(i);
        }

        while(!asc_stack.isEmpty()){
            ans[asc_stack.peek()][1] = -1;
            asc_stack.pop();
        }

        for(int i = n-1;  i >= 0; i--){
            while(!asc_stack.isEmpty() && arr[asc_stack.peek()] > arr[i]){
                ans[asc_stack.peek()][0] = i;
                asc_stack.pop();
            }
            asc_stack.push(i);
        }

        while(!asc_stack.isEmpty()){
            ans[asc_stack.peek()][0] = -1;
            asc_stack.pop();
        }

        return ans;

    }

    public static void main(String[] args){
        //int[] input = {3,4,1,5,6,2,7};
        int[] input = {3,1,3,4,3,5,3,2,2};
        MonotonicStack monotonicStack = new MonotonicStack();
        int[][] ans = monotonicStack.getNearLessNoRepeat(input);
        for(int[] arr : ans){
            System.out.println(arr[0] + " "+arr[1]);
        }
       
    }
     
}
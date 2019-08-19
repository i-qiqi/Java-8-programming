package stack;

import java.util.Stack;

public class T85MaximalRectangle {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max_area = 0;
        for(int i = 0 ; i < heights.length; ++i){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                max_area = Math.max(max_area , heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            max_area = Math.max(max_area, heights[stack.pop()]*(heights.length - stack.peek() - 1));
        }
        return max_area;
    }

    public int maximalRectangle(char[][] matrix){
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max_area = 0;
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                heights[j] = matrix[i][i] == '1' ? heights[j]+1 : 0;
            }
            max_area = Math.max(max_area , largestRectangleArea(heights));
        }

        return max_area;

    }

}

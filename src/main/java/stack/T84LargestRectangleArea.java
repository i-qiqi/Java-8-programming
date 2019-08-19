package stack;

import java.util.Stack;

public class T84LargestRectangleArea {
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
}

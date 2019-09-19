package algo;

import java.util.Stack;

public class T42TrapWater {
    /**
     * stack 
     * O(N)
     * O(N)
     * @param height
     * @return
     */
    public int trap(int[] height){
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while(current < height.length){
            while(!stack.empty() && height[current] > height[stack.peek()]){
                int h = height[stack.peek()];
                stack.pop();
                if(stack.empty()){
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum += distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap_1(int[] height){
       return 0;
    }
}
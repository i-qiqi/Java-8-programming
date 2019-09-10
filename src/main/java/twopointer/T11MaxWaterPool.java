package twopointer;

public class T11MaxWaterPool{
    public int maxArea(int[] height){
        int max_area = 0, l = 0 , r = height.length - 1;
        while(l < r){
            max_area = Math.max(max_area, Math.min(height[1], height[r])*(r-l));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max_area;
    }
}
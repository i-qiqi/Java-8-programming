package swordoffer;

import java.util.Arrays;

public class MinNumberFromArrays {

    public static void main(String[] args){
        int[] numbers = {1 , 21 , 123};
        System.out.println(PrintMinNumber(numbers));
    }

    public static String PrintMinNumber(int[] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int n = numbers.length;
        String[] nums = new String[n];
        for(int i = 0 ; i < numbers.length ; i++){
            nums[i] = Integer.valueOf(numbers[i]).toString();
        }

        Arrays.sort(nums,(s1 , s2)->{return (s1 + s2).compareTo(s2 + s1);});
        String ans = "";
        for(String s : nums){
            ans += s;
        }
        return ans;
    }
}

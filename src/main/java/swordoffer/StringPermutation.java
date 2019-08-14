package swordoffer;

import java.util.ArrayList;

public class StringPermutation {

    static  ArrayList<String> ans = new ArrayList<>();
    /**
     * 去重的全排列就是从第一个数字起，每个数分别与它后面非重复出现的数字交换
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {

    }

    public static void permutationHelper(char[] str_arr  , int begin , StringBuilder s){
        if(s.length() == str_arr.length){
            ans.add(s.toString());
            return ;
        }
        for(int i = begin ; i < str_arr.length ; i++){
            if(!hasRepeated(str_arr , begin , i)){
                swap(str_arr , begin , i);
                s.append(str_arr[i]);
                permutationHelper(str_arr , begin+1 , s);
                s.deleteCharAt(s.length()-1);
                swap(str_arr, begin , i);
            }
        }
    }

    public static boolean hasRepeated(char[] arr , int begin , int k){
        boolean flag = false;
        for(int i = begin ; i < k ; i++){
            if(arr[i] == arr[k]){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void swap(char[] arr , int i , int j){
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}

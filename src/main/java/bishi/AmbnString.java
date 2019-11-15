package bishi;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AmbnString{
    int n , m;

    int[][] mem;
    int cnt = 0;
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      AmbnString so = new AmbnString();
      for(String s : so.backtrack(n , m)){
        System.out.println(s);
      }
     
    }

    public String findKth(int n , int m , int k){
      mem = new int[m+1][n+1];
      List<String> res = backtrack(n, m);
      System.out.println(res);
      
      return res.get(k);
    }

    public List<String>  backtrack(int n , int m){
        if(n == 0 && m == 0){
           List<String> tmp_res = new LinkedList<>();
           tmp_res.add("");
           return tmp_res;
        }
        List<String> res = new LinkedList<>(); 
        if(n > 0){
          List<String> a_res = backtrack(n-1 , m);
          for(String s1 : a_res){
            res.add("a"+s1);
          }
        }
        if(m > 0){
          List<String> b_res = backtrack(n , m-1);
          for(String s2 : b_res){
            res.add("b"+s2);
          }  
        }
        res.add("");
        Collections.sort(res);
        return res;
    }



}
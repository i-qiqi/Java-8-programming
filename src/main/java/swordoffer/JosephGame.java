package swordoffer;

import java.util.ArrayList;

public class JosephGame {
    public static  void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        int n = 7 , m = 3;
        for(int i = 1; i <= n; i++) list.add(i);
        int k = 0;
        while (n > 0){
            k = (k + m - 1) % n;
            System.out.println(list.get(k));
            list.remove(k);
            n--;
        }
        System.out.println("----");
        Joseph_math(3, 3);
    }

    public static  void Joseph_math(int n , int m){
        int  i, s = 0;
        for (i = 2; i <= n; i++)
        {
            s = (s + m) % i;
        }
        System.out.println(s+1);
    }

    public static void joseph_seq(int n , int m){
    }
}

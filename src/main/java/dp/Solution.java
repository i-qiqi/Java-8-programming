package dp;

import java.util.Scanner;
public class Solution {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String ans = "";
////        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
////            String src = in.nextLine();
////            String dst = in.next();
//        String src = "AB";
//        String dst = "BA";
//            boolean res = isInclude(src, dst);
//            if(res == true){
//                ans += "1";
//            }else{
//                ans += "0";
//            }
////        }
//        System.out.println(ans);
//    }
//    public static boolean isInclude(String src , String dst){
//        String nextSrc = src.substring(1) +src.substring(0,1);
//        while(!nextSrc.equals(src)){
//            System.out.println(nextSrc);
//            if(isSubString(nextSrc, dst)){
//                return true;
//            }
//            nextSrc = nextSrc.substring(1) +nextSrc.substring(0,1);
//        }
//
//        return false;
//    }
//
//    public static  boolean isSubString(String src , String dst){
//        for(int i = 0 ; i <= src.length()-dst.length(); i++){
//            if(dst.equals(src.substring(i, i+dst.length()))){
//                return  true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double d = 3.14159265358979;
        int M = 0 , N = 2;

        double min_gap = 1.0;
        for(int i = 2 ; i <= 10000 ; i++){
            int left = (int)(i*d) /1;
            int right = (int)(i*d+1)/1;
            double gap_l = left*1.0/i;
            double gap_r = right*1.0/i;
            if( d - gap_l < gap_r - d){
                if(min_gap > d - gap_l){
                    min_gap = d - gap_l;
                    M = left;
                    N = i;
                }
            }else{
                if(min_gap > gap_r - d){
                    min_gap = gap_r - d;
                    M = right;
                    N = i;
                }
            }
        }

        System.out.println(M+" "+N);
    }

}
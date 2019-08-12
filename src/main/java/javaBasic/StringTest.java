package javaBasic;

import org.junit.Test;

public class StringTest{
    public static void main_1(String args[]){
        String a = "abcd";
        String b = a;
        String b1 = new String(a);

        System.out.println(a == b);
        System.out.println(a == b1);
    }


    /**
     * String Pool
     */

     public static void main_2(String args[]){
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);
        String s3 =  s1.intern();
        String s4  = s2.intern();
        System.out.println(s3 == s4);
     }


     /**
      * 
      * @param args
      */
     public static void main(String args[]){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
     }
     /**
      * 将String常量池 从 Perm 区移动到了 Java Heap区
      * String#intern 方法时，如果存在堆中的对象，会直接保存对象的引用，而不会重新创建对象。
      * @param args
      */

     public static void main_4(String[] args) {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);
    
        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
}
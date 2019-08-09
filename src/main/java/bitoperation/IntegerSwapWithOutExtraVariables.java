package bitoperation;

public class IntegerSwapWithOutExtraVariables {
    public static void main(String args[]){
        swap_pro_1(2 ,3);
        swap_pro_2(2 ,3);
    }

    public static void swap_pro_1(int a , int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = "+a+" b = "+b);
    }

    public static void swap_pro_2(int a , int b){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = "+a+" b = "+b);
    }
}

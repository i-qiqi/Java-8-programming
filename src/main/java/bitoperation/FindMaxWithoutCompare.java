package bitoperation;

public class FindMaxWithoutCompare {
    public static void main(String args[]){
//        getMax(Integer.MAX_VALUE , Integer.MIN_VALUE);
        getMax(Integer.MIN_VALUE , Integer.MAX_VALUE);

    }


    public static int flip(int n){
        return n ^ 1;
    }

    /**
     * [1] n >= 0 => return 1
     * [2] n < 0 => return 0
     * @param n
     * @return
     */
    public static  int sign(int n){
        return flip((n >> 31) & 1);
    }

    public static int getMax(int a , int b){
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }


}

package swordoffer;

public class AppearOnce {
    //一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数
    public static void main(String args[]){
        int[] once = new int[2];

    }

    /**
     * Skills:
     * 将一组数字分为两组，可以根据某位上是否为1来进行分组，即根据和1相与（&1）的结果来进行分组
     * @param nums
     * @param once
     */
    public static void findNumsAppearOnce(int[] nums , int[] once){
        int diff = 0;
        for(int x : nums){
            diff ^= x;
        }

        //diff &= -diff 得到出 diff 最右侧不为 0 的位，
        // 也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来
        diff &= -diff;

        for(int x : nums){
            if((x & diff) == 0){
                once[0] ^= x;
            }else{
                once[1] ^= x;
            }
        }
    }
}

package swordoffer;

public class TimesOf1Between1andN {
    /**
     * a> nums[i] == 0 => high/10 * base
     * b> nums[i] == 1 => high/10 * base + 1 + low
     * c> nums[i] > 1 => high / 10 + base
     * a , b 综合 => (high + 8)/ 10 * base , 如对于513 ， 523 ：
     * (51+8)/10 = 5 x 10 , (52+8)/10 = 6 x 10 会进位
     * @param n
     * @return
     */
    public static int appearTimes(int n){
        int ans = 0;
        for(int base = 1; base <= n ; base *= 10){//第i位
            int high = n / base , low = n % base;
            ans += (high+8)/10 * base + high + (high % 10 == 1 ? low + 1 : 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("123");
        System.out.println(str);
        change(str);
        System.out.println(str);
    }
    public static void change(StringBuilder str){
//        str = "456";
        str = str.append("xx");
    }
}

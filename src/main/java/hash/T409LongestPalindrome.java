package hash;

public class T409LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
    public static int longestPalindrome(String s) {
        int[] char_count = new int[128];
        for(int i = 0 ; i < s.length(); i++){
            char_count[s.charAt(i)]++;
        }
        int flag = 0;
        int ans = 0;
        for(int i = 0 ; i < 128; i++){
            if((char_count[i] & 1) == 0){
                ans += char_count[i];
            }else{
                flag = 1;
                ans += char_count[i] - 1;
            }
        }

        return ans + flag;
    }
}

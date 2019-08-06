package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T3LongestSubstringWithoutRepeatingChar {
    public static void main(String args[]){
        String s = "abcca";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character , Integer> window = new HashMap<>();
        int ans_len = 0;
        int src_len = s.length();
        int win_begin = 0 , win_end = 0;
        while(win_begin < src_len && win_end < src_len){
            if(!window.containsKey(s.charAt(win_end))) window.put(s.charAt(win_end) , 0);
            if(window.get(s.charAt(win_end)) == 0){
                window.put(s.charAt(win_end++) , 1);
                ans_len = Math.max(ans_len , win_end - win_begin);
                System.out.println(s.substring(win_begin, win_end));
            }else if(window.get(s.charAt(win_end)) == 1){
                window.put(s.charAt(win_begin++) , 0);
            }
        }
        return ans_len;

    }

    public static int lengthOfLongestSubstring_1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); //current index of character
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static  int lengthOfLongestSubstring_2(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

package twopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T3LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s == null && s.length() == 0) return 0;
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        int pre = 0, slow = -1;
        for(int i = 0; i < n; ++i){
            char cur = s.charAt(i);
            pre = mp.getOrDefault(cur, slow);
            slow = Math.max(pre, slow);
            ans = Math.max(ans , i - slow);
            mp.put(cur, i);
        }
        return ans;
    }

    public int lengthOfLongestSubstring_1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0 , i = 0 , j = 0;
        while(i < n && j < n){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
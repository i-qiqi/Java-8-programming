package hash;

import java.util.Calendar;
import java.util.HashMap;

public class T3MinimunmWindowSubstring{

    public static void main(String args[]){
        String s = "ADOBECODEBANC" , t = "A";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character , Integer> char_to_count = new HashMap<>();
        int s_len = s.length() , t_len = t.length();
        for(Character c : t.toCharArray()){
            char_to_count.put(c , char_to_count.getOrDefault(c, 0)+1);
        }
        int window_begin = 0 , window_end = 0;
        int window_count_sum = t_len;
        int ans_min_len = Integer.MAX_VALUE , ans_substr_begin = 0, ans_substr_end = 0;

        while(window_end < s_len){
            Character cur_char = s.charAt(window_end);
            if(char_to_count.containsKey(cur_char)) {
                char_to_count.put(cur_char, char_to_count.get(cur_char) - 1);
                if (char_to_count.get(cur_char) >= 0) { //!!！
                    window_count_sum--;
                }
            }
            window_end++;

            while(window_count_sum == 0){
                if(window_end - window_begin < ans_min_len){
                    ans_min_len = window_end - window_begin;
                    ans_substr_begin = window_begin;
                    ans_substr_end = window_end;
                }
                cur_char = s.charAt(window_begin);
                if(char_to_count.containsKey(cur_char)){
                    if(char_to_count.get(cur_char) == 0){
                        window_count_sum++;
                    }
                    char_to_count.put(cur_char, char_to_count.get(cur_char) + 1);
                }
                window_begin++;
            }
        }

        return s.substring(ans_substr_begin, ans_substr_end);
    }

    public static String minWindow_1(String s, String t) {
        HashMap<Character , Integer> window = new HashMap<>();
        HashMap<Character , Integer> needs = new HashMap<>();
        for(Character c : t.toCharArray()){
            needs.put(c , needs.getOrDefault(c, 0)+1);
        }
        int match = 0;
        int win_left = 0 , win_right = 0 , ans_len = Integer.MAX_VALUE , ans_left = 0;
        while(win_right < s.length()){
            Character c_r = s.charAt(win_right);
            if(needs.containsKey(c_r)){
                window.put(c_r , window.getOrDefault(c_r, 0)+1);
                if(window.get(c_r) - (needs.get(c_r)) == 0){
                    match++;
                }
            }
            win_right++;
            while(match == needs.size()){
                if(ans_len > win_right - win_left){
                    ans_left = win_left;
                    ans_len = win_right - win_left;
                }
                Character c_l = s.charAt(win_left);
                if(needs.containsKey(c_l)){
                    window.put(c_l , window.get(c_l)-1);
                    if(window.get(c_l) - needs.get(c_l) < 0){//只要窗口c的数量不小于需要的数量，就是match的，否则match--
                        match--;
                    }
                }
                win_left++;
            }
        }
        return ans_len == Integer.MAX_VALUE ? "" : s.substring(ans_left, ans_left+ans_len);
    }
}

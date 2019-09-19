package twopointer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.lang.Character;

public class T76MinWindow{
    public String minWindow(String s, String t) {
        Map<Character, Integer> tw = new HashMap<>();
        Map<Character, Integer> sw = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            tw.put(c,tw.getOrDefault(c, 0) + 1);
        }
        int n = s.length();
        int L = 0 , R = 0;
        String ans = "";
        int min_len = Integer.MAX_VALUE;
        Character cur = null;
        while(L < n && R < n){
            while(isMatched(tw, sw)){
                if(min_len > R-L){
                    min_len = R - L;
                    ans = s.substring(L, R);
                }
                cur = s.charAt(L);
                sw.put(cur, sw.getOrDefault(cur, 0) - 1);
                L++;
            }
            if(R < n){
                cur = s.charAt(R);
                sw.put(cur, sw.getOrDefault(cur, 0)+1);
                R++;
            }else{
                break;
            }
        }

        return ans;
    }
    
    public boolean isMatched(Map<Character, Integer> tw , Map<Character, Integer> sw){
        if(sw.size() < tw.size()) return false;
        for(Map.Entry<Character,Integer> e : tw.entrySet()){
            Character c = e.getKey();
            if(sw.getOrDefault(c, 0) < e.getValue()){
                return false;
            }
        }
        return true;
    } 
    public static void main(String args[]){
        T76MinWindow t76MinWindow = new T76MinWindow();
        System.out.println(t76MinWindow.minWindow("ADOBECODEBANC", "ABC"));
    }
}
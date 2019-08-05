package hash;

import java.util.HashMap;
import java.util.Map;

public class T290WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba"
               , "dog dog dog dog"));
    }
    public static boolean wordPattern(String pattern, String str) {
        String[] pattern_to_str = new String[128];
        Map<String, Character> str_to_pattern = new HashMap<>();
        //split str => words
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;

        for(int i = 0; i < pattern.length() ; i++){
            if(pattern_to_str[pattern.charAt(i)] == null && str_to_pattern.get(words[i]) == null){
                pattern_to_str[pattern.charAt(i)] = words[i];
                str_to_pattern.put(words[i] , pattern.charAt(i));
            }else if(pattern_to_str[pattern.charAt(i)] != null  && str_to_pattern.get(words[i]) != null){
                if(!pattern_to_str[pattern.charAt(i)].equals(words[i])){
                    return false;
                }
                if(!str_to_pattern.get(words[i]).equals(pattern.charAt(i))){
                    return false;
                }
            }else{
                return false;
            }
        }

        return true;

    }
}

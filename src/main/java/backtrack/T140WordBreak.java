package backtrack;

import java.util.*;

public class T140WordBreak {
    List<String> res = new LinkedList<>();

    Map<String, List<String>> m = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        backtrack(s, 0, wordDict, "");
        return res;
    }

    private void backtrack(String s, int start, List<String> wordDict, String ans) {
        if (start == s.length()) {
            res.add(ans);
        }

        for (String prefix : wordDict) {
            int pre_len = prefix.length();
            if (start + pre_len > s.length())
                continue;
            if (prefix.equals(s.substring(start, start + pre_len))) {
                backtrack(s, start + pre_len, wordDict, ans + (ans.length() == 0 ? "" : " ")+prefix);
            }
        }
    }

    private List<String> backtrack(String s , List<String> wordDict){
        if(m.containsKey(s)) return m.get(s);
        List<String> output = new LinkedList<>();

        if(s.length() == 0){
            output.add("");//不然和其他串连接为空
            return output;
        }
        for(String prefix : wordDict){
            int pre_len = prefix.length();
            if(pre_len > s.length()) continue;
            if(!prefix.equals(s.substring(0,pre_len))) continue;
            for(String suffix : backtrack(s.substring(pre_len),wordDict)) {
                output.add(prefix + (suffix.length() == 0 ? "" : " ") + suffix);
            }
        }
        m.put(s , output);
        return output;
    }

    public static void main(String[] args){
        String s = "pineapplepenapple";
        String[]  wordDict= {"apple", "pen", "applepen", "pine", "pineapple"};
        T140WordBreak wb = new T140WordBreak();
        System.out.println(wb.backtrack(s , Arrays.asList(wordDict)));
    }
}

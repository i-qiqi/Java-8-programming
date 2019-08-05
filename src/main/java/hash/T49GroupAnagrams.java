package hash;

import java.util.*;

public class T49GroupAnagrams {
    public static void main(String[] args) {
        String[] testStrs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = groupAnagrams(testStrs);
        System.out.println(ans.toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> anagram_groups = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++){
            char[] str_arr = strs[i].toCharArray();
            Arrays.sort(str_arr);
            String sorted_str = new String(str_arr);
            if(!anagram_groups.containsKey(sorted_str)){
                List<String> group_list = new ArrayList<>();
                group_list.add(strs[i]);
                anagram_groups.put(sorted_str , group_list);
            }else{
                anagram_groups.get(sorted_str).add(strs[i]);
            }
        }

        //直接将map中所有值添加进去
        ans.addAll(anagram_groups.values());

        return ans;
    }
}

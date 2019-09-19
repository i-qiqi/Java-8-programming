package graphsearch;

import java.util.LinkedList;
import java.util.List;

public class T93IPAddressSplit {
    List<String> output = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s , 4, "");
        return output;
    }

    private void backtrack(String s , int seg_num, String ans){
        if(seg_num < 0) return ;
        if(seg_num == 0 && s.length() == 0){
            output.add(ans.substring(0,ans.length()-1));
            return;
        }
        int n = Math.min(4 , s.length());
        for(int i = 0 ; i < n ; i++){
            String cur_seg = s.substring(0, i+1);
            if(s.charAt(0) == '0' && cur_seg.length() == 1){
                backtrack(s.substring(1) , seg_num - 1 , ans + "0.");
            }
            if(s.charAt(0) != '0' && Integer.parseInt(cur_seg) <= 255){
                backtrack(s.substring(i+1) , seg_num - 1 , ans+s.substring(0 , i+1)+".");
            }
        }
    }

    public static void main(String[] args){
        T93IPAddressSplit t93IPAddressSplit = new T93IPAddressSplit();
        List<String> output = t93IPAddressSplit.restoreIpAddresses("25525511135");
        System.out.println(output);
    }
}

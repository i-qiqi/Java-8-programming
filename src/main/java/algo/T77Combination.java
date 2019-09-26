package algo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T77Combination{

    public List<String> comb(String s , int k){
        char[] strs = s.toCharArray();
        int n = s.length();
        int nbit = 1 << n;
        List<String> output = new LinkedList<>();
        for(int i = 1; i < nbit; i++){
            String ans = "";
            for(int j = 0; j < n; j++){
                int tmp = 1<<j;
                if((tmp & i)!= 0){//检查每一位是否为1
                    ans = strs[n-j-1]+ans;
                }
            }
            if(ans.length() == k) output.add(ans);
        }

        Collections.sort(output);

        return output;
    }

    int n , k;
    List<List<Integer>> output = new LinkedList<>();
    public void backtrack(int first , LinkedList<Integer> curr){
        if(curr.size() == k){
            output.add(new LinkedList<>());
        }
        for(int i = first ; i < n + 1; i++){
            curr.add(i);
            backtrack(i+1, curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args){
        T77Combination so = new T77Combination();
        System.out.println(so.comb("1234" , 2));
    }

}
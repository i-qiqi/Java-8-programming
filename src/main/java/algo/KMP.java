package algo;

import javax.swing.JLabel;

public class KMP{
    int[] next;
    private void getNext(char[] p){
        int p_len = p.length;
        next = new int[p.length];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < p_len -1){
            if(k == -1 || p[j] == p[k]){
                ++k;
                ++j;
                next[j] = k;
            }else{
                k = next[k];
            }
        }

        for(int num : next){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int kmpSearch(String s , String p){
        getNext(p.toCharArray());
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = p.length();
        while(i < m && j < n){
            if(j == -1 || s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }

        return j == n ? i - j : -1;
    }

    public static void main(String[] args){
        String s = "abacababc";
        String p = "abab";
        KMP kmp = new KMP();
        System.out.println(kmp.kmpSearch(s, p));
    }
}
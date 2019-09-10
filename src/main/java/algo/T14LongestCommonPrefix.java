package algo;

public class T14LongestCommonPrefix{
    /**
     * O(S) , 水平扫描
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; ++i){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length() -1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args){
        String s1 = "flower";
        String s2 = "xx";
        int idx = s1.indexOf(s2);
        while(s2.indexOf(s1)!=0){
            s1 = s1.substring(0,s1.length() -1);
            // if(s1.isEmpty())  System.out.println(idx);
        }
        System.out.println(s2.indexOf(s1));
    }
}

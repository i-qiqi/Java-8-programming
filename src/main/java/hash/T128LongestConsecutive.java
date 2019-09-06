package hash;

import java.util.HashSet;
import java.util.Set;

public class T128LongestConsecutive {
    public int longestConsecutive(int[] nums){
        Set<Integer> num_set = new HashSet<>();
        for(int num : nums){
            num_set.add(num);
        }

        int longest_streak = 0;
        for(int num : num_set){
            if(!num_set.contains(num - 1)){
                int current_num = num;
                int current_streak = 1;
                while(num_set.contains(current_num+1)){
                    current_num += 1;
                    current_streak += 1;
                }

                longest_streak = Math.max(current_streak, longest_streak);
            }
        }

        return longest_streak;
    }
}

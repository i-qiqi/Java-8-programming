package algo;

public class T55JumpGameI{
    public boolean canJumpFromPosition(int pos , int[] nums){
        if(pos  == nums.length - 1){
            return true;
        }

        int furthest_jump = Math.min(pos + nums[pos] , nums.length - 1);
        for(int next_pos = pos+1 ; next_pos <= furthest_jump ; ++next_pos){
            if(canJumpFromPosition(next_pos, nums)) return true;
        }

        return false;
    }
    public boolean canJump(int[] nums){
        return canJumpFromPosition(0, nums);
    }

    enum State{
        GOOD,BAD,UNKNOWN
    }

    public canJump_dp(int[] nums){
        State[] mark = new State[nums.length];

        for(int i = 0; i < mark.length; i++){
            mark[i] = State.UNKNOWN;
        }

        mark[mark.length - 1] = State.GOOD;
        for(int i = nums.length - 2; i >= 0; --i){
            int furthest_jump = Math.min(i + nums[i] , nums.length -1);
            for(int j = i + 1; j <= furthest_jump; j++){
                if(mark[j] == State.GOOD){
                    mark[i] = State.GOOD;
                    break;
                }
            }
        }

        return mark[0] == State.GOOD;
    }

    public boolean canJump_greedy(int[] nums){
        int last_pos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last_pos) {
                last_pos = i;
            }
        }
        return last_pos == 0;
    }
}
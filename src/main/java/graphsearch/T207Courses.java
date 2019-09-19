package graphsearch;

import java.util.ArrayList;
import java.util.List;

public class T207Courses {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<Integer>[] graphic = new List[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            graphic[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites){
            graphic[pre[0]].add(pre[1]);
        }
        boolean[] globalMarked = new boolean[numCourses];
        boolean[] localMarked = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(hasCycle(globalMarked, localMarked, graphic, i)){
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(boolean[] globalMarked , boolean[] localMarked , List<Integer>[] graphic , int curNode){
        if(localMarked[curNode]){
            return true;
        }

        if(globalMarked[curNode]){
            return false;
        }

        globalMarked[curNode] = true;
        localMarked[curNode] = true;

        for(int nextNode : graphic[curNode]){
            if(hasCycle(globalMarked, localMarked, graphic, nextNode)){
                return true;
            }
        }

        localMarked[curNode] = false;
        return false;
    }

    public boolean canFinish_1(int numCourses, int[][] prerequisites){
      int[][] adjacency = new int[numCourses][numCourses];
      int[] flags = new int[numCourses];
      for(int[] cp : prerequisites){
          adjacency[cp[1]][cp[0]] = 1;
      }
      for(int i = 0; i < numCourses; i++){
          if(!dfs(adjacency, flags,i)) return false;
      }

      return true;
    }

    private boolean dfs(int[][] adjacency, int[] flags, int i){
          if(flags[i] == 1) return false;
          if(flags[i] == -1) return true;
          flags[i] = 1;
          for(int j = 0; j < adjacency.length; j++){
              if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j))
                return false;
          }
          flags[i] = -1;
          return true;
    }

}
package graphsearch;


public class MinPath {
    public class Node{
        int x;
        int y;
        int distance;
        Node(int i , int j, int d){
            this.x = i;
            this.y = j;
            this.distance = d;
        }
    }
//    public int minPathLength(int[][] matrix, int end_x , int end_y){
//      int[][] directions = {{0,1},{0,-1},{1,0}, {-1,0}};
//      int m = matrix.length, n = matrix[0].length;
//      Queue<Pair<Integer,Integer>> q = new LinkedList<>();
//      int[][] visited = new int[m][n];
//      q.offer(new Pair<>(0, 0));
//      int distance = 0;
//      while(!q.isEmpty()){
//        int size = q.size();
//        //visit
//        distance++;
//        while(size-- > 0){//size 为每一层的节点数量 //双while法
//            Pair<Integer, Integer> cur = q.poll();
//            int x = cur.getKey(), y = cur.getValue();
//            visited[x][y] = 1;
//            for(int[] d : directions){
//                int next_x = x+d[0];
//                int next_y = y+d[1];
//                if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n
//                            && matrix[next_x][next_y] == 1 && visited[next_x][next_y] == 0){
//                        if(next_x == end_x && next_y == end_y) return distance;
//                        q.offer(new Pair<>(next_x, next_y));
//                }
//            }
//        }
//      }
//
//      return -1;
//
//    }
//    public int minPathLength_1(int[][] matrix, int end_x , int end_y){
//        int[][] directions = {{0,1},{0,-1},{1,0}, {-1,0}};
//        int m = matrix.length, n = matrix[0].length;
//        Queue<Node> q = new LinkedList<>();
//        int[][] visited = new int[m][n];
//        q.offer(new Node(0, 0 , 0));
//        while(!q.isEmpty()){
//          Node cur = q.poll();
//          int x = cur.x, y = cur.y, distance = cur.distance;
//          visited[x][y] = 1;
//          for(int[] d : directions){
//              int next_x = x+d[0];
//              int next_y = y+d[1];
//              int next_d = distance+1;
//              if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n
//                          && matrix[next_x][next_y] == 1 && visited[next_x][next_y] == 0){
//                      if(next_x == end_x && next_y == end_y) return next_d;
//                      q.offer(new Node(next_x, next_y, next_d));
//              }
//          }
//        }
//
//        return -1;
//
//      }


//    public static void main(String[] args){
//        int[][] matrix = {
//            {1,1,0,1},
//            {1,0,1,1},
//            {1,1,1,0},
//            {1,0,1,1}
//        };
//
//        int ans = 0;
//
//        MinPath minPath = new MinPath();
//        System.out.println(minPath.minPathLength(matrix, 0, 3));
//        System.out.println(minPath.minPathLength_1(matrix, 0, 3));
//    }
}
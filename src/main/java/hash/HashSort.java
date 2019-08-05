package hash;

public class HashSort {

    public static void main(String[] args) {
        int[] ramdom= {999,1,444,7,20,
            9,1,3,7,7};
        int[] hash_map = new int[1000];
        for(int i = 0 ; i < 10 ; i++){
            hash_map[ramdom[i]]++;
        }

        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < hash_map[i] ; j++){
                System.out.println(i);
            }
        }
    }
}

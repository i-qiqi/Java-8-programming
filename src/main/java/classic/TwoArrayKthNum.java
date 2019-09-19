package classic;

public class TwoArrayKthNum{
    public int kthSmallestOfTwoArrays(int[] A , int l1, int r1,  int[] B,  int l2 , int r2, int k){
        if(A == null || B ==  null || l1 > r1 || l2 > r2 ) return -1;
        int m = r1 - l1 + 1 , n = r2 - l2 + 1;
        if(k < 0 || k > m + n) return -1;

        int i = (int) (m * 1.0 / (m + n) * (k-1)) + l1;
        int j = (k - 1) - i + l2;

        int leftA = (i == l1) ? Integer.MIN_VALUE : A[i-1];
        int rightA = (i == r1) ? Integer.MAX_VALUE : A[i];
        int leftB = (j == l2) ? Integer.MIN_VALUE : B[j-1];
        int rightB = (j == r2) ? Integer.MAX_VALUE : B[j];

        if(rightA < rightB){
            if(rightA > leftB){
                return rightA;
            }else{
                return kthSmallestOfTwoArrays(A, i+1, r1, B, l2, j, k - (i - l1+1));
            }
        }else{
            if(rightB > leftA){
                return rightB;
            }else{
                return kthSmallestOfTwoArrays(A, l1 , i, B, j+1 , r2, k - (j - l2+1));
            }
        }
    }

    public static void main(String[] args){
        int[] A = {1,2,3,4,5};
        int[] B = {3,4,5};
        TwoArrayKthNum twoArrayKthNum = new TwoArrayKthNum();
        int kth = twoArrayKthNum.kthSmallestOfTwoArrays(A, 0, 4, B, 0, 2, 3);
        System.out.println(kth);
    }
}
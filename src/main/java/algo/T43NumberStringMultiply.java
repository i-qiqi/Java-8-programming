package algo;

public class T43NumberStringMultiply{
    public String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder str = new StringBuilder();

        int[] arr = new int[len1+len2];

        for(int i = len1 - 1; i >= 0; --i){
            for(int j = len2 - 1; j >= 0; --j){
                int digit1 = num1.charAt(i) - 48;
                int digit2 = num2.charAt(j) - 48;
                arr[i+j] += digit1*digit2;
                if(arr[i+j] >= 10 && (i + j) != 0){
                    arr[i + j - 1] += arr[i + j] / 10;
                    arr[i+j] = arr[i + j] % 10;  
                }
            }
        }

        for(int i = 0; i < len1 + len2 - 1; ++i){
            str.append(arr[i]);
        }

        return str.toString();
    }
}
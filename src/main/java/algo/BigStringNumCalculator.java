package algo;

import java.util.Scanner;

public class BigStringNumCalculator{
    public  String add(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int minus = 0;
        if(len1 == 0) return str2;
        if(len2 == 0) return str1;
        
        //处理符号
        if(str1.charAt(0) == '-' && str2.charAt(0) == '-'){
            minus = 1;
            str1 = str1.substring(1);
            str2 = str2.substring(1);
            return '-'+add(str1, str2);
        }else if(str1.charAt(0) == '-' && str2.charAt(0) != '-'){
            str1 = str1.substring(1);
            return substract(str2, str1);
        }else if(str1.charAt(0) != '-' && str2.charAt(0) == '-'){
            str2 = str2.substring(1);
            return substract(str1, str2);
        }

        //补０
        int max_len = 0;
        String result = "";
        if(len1 > len2){
            max_len = len1;
            for(int i = 0; i < (len1 - len2); i++){
                str2 = '0' + str2;
            }
        }else if(len2 > len1){
            max_len = len2;
            for(int i = 0; i < (len2 - len1); i++){
                str1 = '0' + str1;
            }
        }else{
            max_len = len1;
        }

        int carry = 0;
        for(int i = max_len-1 ; i >= 0; i--){
            int tmp = (str1.charAt(i) - '0') + (str2.charAt(i)- '0') + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            result = (char)(tmp+'0') + result;
        }

        if(carry == 1) result = 1 + result;
        return result;
    }


    public  String substract(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int minus = 0; // 0 : + , 1 : -
        if(len1 > len2){
            for(int i = 0 ; i < len1 - len2; i++){
                str2 = '0' + str2;
            }
        }else if(len1 < len2){
            for(int i = 0; i < len2 - len1; i++){
                str1 = '0' + str1;
            }
            minus = 1;
            return '-'+ substract(str2, str1);
        }else{
            if(str1.compareTo(str2) < 0){
                minus = 1;
                return '-'+substract(str2, str1);
            }
        }

        int carry = 0;
        String result = "";
        for(int i = len1 - 1; i >= 0; i--){
            int tmp = (str1.charAt(i) - '0') - (str2.charAt(i) - '0') - carry;
            if(tmp < 0){
                tmp += 10; //借位
                carry = 1;
            }else{
                carry = 0;
            }
            result = (char)('0' + tmp) + result;
        }
        return result;
    }


    public String multiply(String num1 , String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder str = new StringBuilder();

        int[] arr = new int[len1+len2];

        for(int i = len1 - 1; i >= 0; --i){
            for(int j = len2 - 1; j >= 0; --j){
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                arr[i + j + 1] += digit1*digit2;
                if(arr[i + j + 1] >= 10){
                    arr[i + j] += arr[i + j + 1] / 10;
                    arr[i + j + 1] = arr[i + j + 1] % 10;  
                }
            }
        }
        
        int k = 0;
        while(k < len1 + len2){
            if(arr[k++] == 0) continue;
            else break;
        }

        for(int i = k - 1; i < len1 + len2; ++i){
            str.append(arr[i]);
        }

        return str.toString();
    }

    public static void main(String[] args){
        // System.out.println("1".compareTo("10"));
        // String str1 = "";
        // String str2 = "";
        BigStringNumCalculator calculator = new BigStringNumCalculator();
        // Scanner sc = new Scanner(System.in);
        // while(sc.hasNext()){
        //     str1 = sc.nextLine();
        //     str2 = sc.nextLine();
        //     String result =  calculator.add(str1, str2);
        //     if(result.charAt(0) == '-'){
        //         System.out.print("-");
        //         result = result.substring(1);
        //     }
        //     int i = 0;
        //     int len = result.length();
        //     while((i++) < len){
        //         if(result.charAt(0) == '0'){
        //             result = result.substring(1);
        //         }else{
        //             break;
        //         }
        //     }

        //     System.out.println(result);
        // }

        // sc.close();
        String result = calculator.multiply("123", "456");
        System.out.println(result);

    }
}
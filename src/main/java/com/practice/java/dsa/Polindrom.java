package com.practice.java.dsa;

public class Polindrom {
    public static void main(String[] args) {
        //boolean isCorrect = isPalindrome(-121);
        String str = String.valueOf(-121);
        boolean isStringCorrect =  isStringPolidrome(str);
        System.out.println(isStringCorrect);
        //System.out.println(isCorrect);
    }
    public static boolean isStringPolidrome(String str1) {
        String str = String.valueOf(str1);
        String reverseStr = "";
        for(int i=str.length()-1; i>= 0; i--){
            reverseStr +=str.charAt(i);
        }
        if(str.equalsIgnoreCase(reverseStr) ){
            return true;
        }
        return false;
    }
    public static boolean isPalindrome(int x) {
        int reverse =0;
        int a = x;
        while(x != 0 ){
            int digits = x%10;
            reverse = reverse*10+digits;
            x = x/10;
        }
        if(a == reverse ){
            return true;
        }
        return false;
    }
}

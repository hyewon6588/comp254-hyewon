package Ex02;

import java.util.Scanner;

public class Ex02 {
    public static boolean palindrome(String s){
        //default value
        boolean isPalindrome=false;

        //if there is no more letter to compare
        if(s.length()==0 || s.length()==1){
            isPalindrome=true;
            return isPalindrome;
        }
        if(s.charAt(0)==s.charAt(s.length()-1)){
            //if the first and last letter is the same
            return palindrome(s.substring(1,s.length()-1));
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        //test code
        Scanner s=new Scanner(System.in);
        System.out.println("Please enter the string.");
        String str=s.next();
        boolean isPalindrome=palindrome(str);
        if(isPalindrome){
            System.out.println(str+" is a palindrome.");
        }else{
            System.out.println(str+" is not a palindrome.");
        }
    }
}

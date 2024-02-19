package Ex01;

import java.util.Scanner;

public class Ex01 {
    public static int product(int m,int n){
        int product=0;
        //m*1=m
        if (n == 1)
            return m;

        //n*1=n
        if(m==1)
            return n;

        //adds m to product n times
        //and count down from n to 1
        product=product(m, n-1) + m;
        return product;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        try{
            System.out.print("Enter the value of m: ");
            int m=s.nextInt();
            System.out.print("Enter the value of n: ");
            int n=s.nextInt();

            if(m<=0 || n<=0){
                throw new IllegalArgumentException();
            }
            System.out.println("Product of "+m+" and "+n+": "+product(m,n));
        }catch(IllegalArgumentException iae){
            System.out.println("Invalid value: m and n must be positive values.");
        } catch(Exception e){
            System.out.println("Invalid input: m and n must be positive integers.");
        }finally {
            s.close();
        }
    }
}

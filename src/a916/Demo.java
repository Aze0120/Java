package a916;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int a=30;
        int b;
        int c;
        Scanner sc=new Scanner(System.in);
        b=sc.nextInt();
        c=sc.nextInt();
        //int max;
        //max=(a>b?a:b)>c?(a>b?a:b):c;
        System.out.println(Math.max(Math.max(a,b),c));
        //System.out.println(max);
    }
}

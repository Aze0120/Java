package a917;

import java.util.Scanner;

public class Three {
    public static int three_max(int a,int b){
        return Math.max(a,b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("依次输入a,b,c的值:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(three_max(three_max(a,b),c));
    }
}

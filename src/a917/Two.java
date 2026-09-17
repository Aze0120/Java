package a917;

import java.util.Scanner;

public class Two {
    public static int sum(int a, int b) {
        int sum=0;
        for(int i=a;i<=b;i++){
            if(i%2==0){
                sum=sum+i;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入a的值:");
        int a = sc.nextInt();
        System.out.println("请输入大于a的b的值:");
        int b = sc.nextInt();
        System.out.println(a+"到"+b+"的偶数和:"+sum(a,b));
    }
}

package a914;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 100 + 1);
        Scanner sc = new Scanner(System.in);
        int b = 0;
        while (true) {
            System.out.println("请输入你猜测的数字(1-100):");
            int a = sc.nextInt();
            if (a > number) {
                System.out.println("大了");
            } else if (a < number) {
                System.out.println("小了");
            } else {
                System.out.println("好了");
                System.exit(0);
            }
            b++;
            if (b == 5) {
                System.out.println("卡了");
                System.exit(0);
            }
        }
    }
}
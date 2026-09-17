package a916;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
//根据用输入的分数，给该学生评级
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数：");
        int score = sc.nextInt();
        //if (score >= 90 && score <= 100) {
        //    System.out.println("A");
        //} else if (score >= 80 && score <= 89) {
        //    System.out.println("B");
        //} else if (score >= 70 && score <= 79) {
        //    System.out.println("C");
        //} else if (score >= 60 && score <= 69) {
        //    System.out.println("D");
        //} else if (score >= 0 && score <= 59) {
        //    System.out.println("E");
        //} else {
        //    System.out.println("输入的分数有误,应输入0-100");
        //}
        //使用switch来重写
        switch (score / 10) {
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                System.out.println("E");
                break;
            default:
                System.out.println("输入的分数有误,应输入0-100");
                break;
        }
    }
}

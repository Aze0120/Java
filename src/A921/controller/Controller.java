package A921.controller;

import java.util.Scanner;

public class Controller {
    public static Scanner sc = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("1.学生管理");
        System.out.println("2.班级管理");
        System.out.println("0.退出");
        System.out.println("请输入选择:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                StuController.printMenu();
                break;
            case 2:
                ClaszController.printMenu();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("请重新输入:");
                break;
        }
    }
}

package a914;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selcet;
        while (true) {
            System.out.println("***企业智能设备资产管理系统***");
            System.out.println("***     1.设备新增      ***");
            System.out.println("***     2.设备查询      ***");
            System.out.println("***     3.设备修改      ***");
            System.out.println("***     4.设备删除      ***");
            System.out.println("***     5.设备状态      ***");
            System.out.println("***     6.台账         ***");
            System.out.println("***     0.退出         ***");
            System.out.println("*************************");
            System.out.println("请输入你的选择:");
            selcet = sc.nextInt();
            switch (selcet) {
                case 1:
                    System.out.println("设备增加成功");
                    break;
                case 2:
                    System.out.println("设备查询成功");
                    break;
                case 3:
                    System.out.println("设备修改成功");
                    break;
                case 4:
                    System.out.println("设备删除成功");
                    break;
                case 5:
                    System.out.println("设备状态成功");
                    break;
                case 6:
                    System.out.println("台账成功");
                    break;
                case 0:
                    System.out.println("系统即将退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
                    break;
            }
        }

    }
}

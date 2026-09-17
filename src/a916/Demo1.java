package a916;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        //int year;
        //int month;
        //int day = 0;
        //int number = 0;
        //System.out.print("请输入年份:");
        //year = sc.nextInt();
        //System.out.print("请输入月份:");
        //month = sc.nextInt();
        //for (int i = 0; i <= 12; i++) {
        //    switch (i) {
        //        case 1:
        //            day = 31;
        //            break;
        //        case 2:
        //            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
        //                day = 29;
        //            } else {
        //                day = 28;
        //            }
        //            break;
        //        case 3:
        //            day = 31;
        //            break;
        //        case 4:
        //            day = 30;
        //            break;
        //        case 5:
        //            day = 31;
        //            break;
        //        case 6:
        //            day = 30;
        //            break;
        //        case 7:
        //            day = 31;
        //            break;
        //        case 8:
        //            day = 31;
        //            break;
        //        case 9:
        //            day = 30;
        //            break;
        //        case 10:
        //            day = 31;
        //            break;
        //        case 11:
        //            day = 30;
        //            break;
        //        case 12:
        //            day = 31;
        //            break;
        //    }
        //    if (i < month) {
        //        number = day + number;
        //    } else {
        //        break;
        //    }
        //}
        //System.out.println("请输入日期:");
        //day = sc.nextInt();
        //System.out.println("是今年的第" + (day + number) + "天");
        //给出年月日，输出是当年的第几天
        Scanner sc = new Scanner(System.in);
        int year;
        int month;
        int day;
        System.out.print("请输入年份:");
        year = sc.nextInt();
        System.out.print("请输入月份:");
        month = sc.nextInt();
        System.out.println("请输入日期:");
        day = sc.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("月份必须在 1~12 之间");
            return;
        }
        switch (--month) {
            case 11:
                day += 30;
                //no break
            case 10:
                day += 31;
                //no break
            case 9:
                day += 30;
                //no break
            case 8:
                day += 31;
                //no break
            case 7:
                day += 31;
                //no break
            case 6:
                day += 30;
                //no break
            case 5:
                day += 31;
                //no break
            case 4:
                day += 30;
                //no break
            case 3:
                day += 31;
                //no break
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    day += 29;
                } else {
                    day += 28;
                }
                //no break
            case 1:
                day += 31;
        }
        System.out.println("是今年的第" + day + "天");


    }
}

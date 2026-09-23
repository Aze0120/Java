package A921.controller;

import A921.entity.Clasz;
import A921.service.ClaszService;
import A921.service.Impl.ClaszServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ClaszController {
    public static Scanner sc = new Scanner(System.in);
    public static ClaszService claszService = new ClaszServiceImpl();

    public static void printMenu() {
        System.out.println("1.创建班级");
        System.out.println("2.删除班级");
        System.out.println("3.修改班级名称");
        System.out.println("4.查询班级");
        System.out.println("5.查询所有班级");
        System.out.println("6.返回上一级菜单");
        System.out.println("0.退出");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                save();
                break;
            }
            case 2: {
                delete();
                break;
            }
            case 3: {
                update();
                break;
            }
            case 4: {
                findone();
                break;
            }
            case 5: {
                findall();
                break;
            }
            case 6: {
                Controller.printMenu();
                break;
            }
            case 0: {
                System.exit(-1);
                break;
            }
            default: {
                System.out.println("请输入0-6的编号:");
                break;
            }
        }
        printMenu();
    }

    public static void save() {
        System.out.println("请输入班级名称:");
        String name = sc.next();
        Clasz clasz = new Clasz(null, name, null);
        if (claszService.createClazz(clasz)) {
            System.out.println("班级创建成功！");
        } else {
            System.out.println("班级创建失败！");
        }
    }

    public static void delete() {
        System.out.println("请输入需要删除的班级的编号:");
        int cid = sc.nextInt();
        if (claszService.deleteClazz(cid)) {
            System.out.println("班级删除成功！");
        } else {
            System.out.println("班级删除失败！");
        }
    }

    public static void update() {
        System.out.println("请输入需要更新的班级的编号:");
        int cid = sc.nextInt();
        System.out.println("请输入班级名称:");
        String name = sc.next();
        System.out.println("请输入班级人数:");
        int cnum = sc.nextInt();
        Clasz clasz = claszService.getClazzByCid(cid);
        int num = clasz.getCnum();
        if (cnum < clasz.getCnum()) {
            System.out.println("班级人数不可小于更新前的人数！");
            System.out.println("请重新更新班级！");
            update();
        } else {
            Clasz clasz1 = new Clasz(cid, name, cnum);
            if (claszService.updateClazz(clasz)) {
                System.out.println("更新成功！");
            } else {
                System.out.println("更新失败！");
            }
        }
    }

    public static void findone() {
        System.out.println("请输入查询的班级的编号:");
        int cid = sc.nextInt();
        Clasz clasz = claszService.getClazzByCid(cid);
        if (clasz != null) {
            System.out.println("cid\t\tcname\t\tcnum");
            System.out.println(clasz.getCid() + "\t\t" + clasz.getCname() + "\t\t" + clasz.getCnum());
            System.out.println("查询成功！");
        } else {
            System.out.println("查询失败！");
        }
    }

    public static void findall() {
        List<Clasz> claszList = claszService.getAllClazzes();
        if (claszList != null) {
            System.out.println("cid\t\tcname\t\tcnum");
            for (Clasz clasz : claszList) {
                System.out.println(clasz.getCid() + "\t\t" + clasz.getCname() + "\t\t" + clasz.getCnum());
            }
        } else {
            System.out.println("查询失败！");
        }
    }
}

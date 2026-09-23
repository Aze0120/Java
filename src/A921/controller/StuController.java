package A921.controller;

import A921.dao.ClaszDAO;
import A921.entity.Stu;
import A921.service.Impl.StuServiceImpl;
import A921.service.StuService;

import java.util.List;
import java.util.Scanner;

public class StuController {
    public static Scanner sc = new Scanner(System.in);
    public static StuService stuService = new StuServiceImpl();

    public static void printMenu() {
        System.out.println("1.学生入学");
        System.out.println("2.学生退学");
        System.out.println("3.学生转班");
        System.out.println("4.查询one学生");
        System.out.println("5.查询所有学生");
        System.out.println("6.查询班级内所有学生");
        System.out.println("7.返回上一级菜单");
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
                findclassall();
                break;
            }
            case 7: {
                Controller.printMenu();
                break;
            }
            case 0: {
                System.exit(-1);
                break;
            }
            default: {
                System.out.println("请输入0-7的编号:");
                break;
            }
        }
        printMenu();
    }

    private static void save() {
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();
        System.out.println("请输入学生手机号码:");
        String phone = sc.next();
        System.out.println("请输入学生加入的班级:");
        int cid = sc.nextInt();
        Stu stu = new Stu(name, age, phone, cid);
        if (stuService.enterSchool(stu)) {
            System.out.println("入学成功！");
        } else {
            System.out.println("入学失败!");
        }
    }

    private static void delete() {
        System.out.println("请输入退学学生的学号:");
        int id = sc.nextInt();
        if (stuService.leaveSchool(id)) {
            System.out.println("退学成功！");
        } else {
            System.out.println("退学失败!");
        }
    }

    private static void update() {
        System.out.println("请输入转班学生的学号:");
        int id = sc.nextInt();
        System.out.println("请输入转入班级的班级号:");
        int cid = sc.nextInt();
        if (stuService.claszTransfer(id, cid)) {
            System.out.println("转班成功！");
        } else {
            System.out.println("转班失败!");
        }
    }

    private static void findone() {
        System.out.println("请输入查询学生的学号:");
        int id = sc.nextInt();
        Stu stu = stuService.getStuBySid(id);
        if (stu != null) {
            System.out.println("sid\tsname\tsage\tsphone\t\tcid");
            System.out.println(stu.getSid() + "\t" + stu.getSname() + "\t\t" + stu.getSage() + "\t\t" + stu.getSphone() + "\t\t" + stu.getCid());
            System.out.println("查询成功！");
        } else {
            System.out.println("查询失败!");
        }
    }

    private static void findall() {
        List<Stu> stuList = stuService.getAllStus();
        if (stuList != null) {
            System.out.println("sid\tsname\tsage\tsphone\t\tcid");
            for (Stu stu : stuList) {
                System.out.println(stu.getSid() + "\t" + stu.getSname() + "\t\t" + stu.getSage() + "\t\t" + stu.getSphone() + "\t\t" + stu.getCid());
            }
        } else {
            System.out.println("查询失败！");
        }
    }

    public static void findclassall() {
        ClaszController.findall();
        System.out.println("请输入班级编号:");
        int id = sc.nextInt();
        List<Stu> stuList = stuService.getStusClasz(id);
        if (stuList != null) {
            System.out.println("sid\tsname\tsage\tsphone");
            for (Stu stu : stuList) {
                System.out.println(stu.getSid() + "\t" + stu.getSname() + "\t\t" + stu.getSage() + "\t\t" + stu.getSphone());
            }
        } else {
            System.out.println("查询失败！");
        }
    }
}
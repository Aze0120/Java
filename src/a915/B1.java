package a915;

import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Student stu1 = new Student(1,123456,"李四");
        Student stu2 = new Student(2,158974,"张三");
        Student stu3 = new Student();
        stu3.setName("王五");
        System.out.println(stu1);
        System.out.println(stu2);
        System.out.println(stu3);
        Student stu=new Student();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的学号:");
        stu.setId(sc.nextLong());
        System.out.println("请输入你的手机号:");
        stu.setIphone(sc.nextLong());
        System.out.println("请输入你的名字:");
        stu.setName(sc.next());
        System.out.println("学生信息"+stu);
    }
}

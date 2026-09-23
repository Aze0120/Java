package a917.Demo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        //2026-09-17  Scanner中next方法没有直接获得日期类型的
        Scanner scanner = new Scanner(System.in);
        //字符串类型的值不能直接存入日期类型中 ，需要转换为日期类型
        String dateStr = scanner.next();
        //日期格式类  "yyyy-MM-dd"  yyyy表示4位的年份 MM表示2位的月份  dd表示2位的日期  a bcd-ef-hg
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //将字符串转成日期
        try {
            Date date = simpleDateFormat.parse(dateStr);
            System.out.println(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

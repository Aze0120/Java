package a916;

public class Demo3 {
    public static void main(String[] args) {
        //int i = 1;
        //while (i <= 10) {
        //    System.out.println(i);
        //    i += 2; //循环经常会漏写变化量
        //}
//逢7过  个位是7  十位是7 是7的倍数
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 7 || i / 10 == 7 || i % 7 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}

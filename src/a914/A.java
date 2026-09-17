package a914;

public class A {
    public static void main(String[] args) {
        System.out.println("Hello World");
        // 声明一个整数
        //8个字节，64位
        long l = 100;
        //4个字节，32位
        int blood = 100;
        //2个字节，16位
        short s = 100;
        //声明一个字节 8位
        byte b = 100;
        //从负数到正数 -128<-->127
        //声明一个小数
        float salary = 10000.5f;
        double salary2 = 10000.5;
        //布尔型
        boolean isVip = true;
        boolean isVip2 = false;
        //字符型 2个字节 16位
        char c = 'a';
        char c2 = '中';
        int a=100;
        int e=20;
        int o=a/e;
        System.out.println(o);
        boolean q=a>e;
        System.out.println(q);
        int f = 10;
        //f = f + 1;
        //f += 1; //将f与1的和存入f
        //f -= 1;//将f与1的差存入f
        //f *= 2;//将f与2的积存入f
        //f /= 2;//将f与2的整除的值存入f
        f %= 2;//将f与2的取余的值存入f
        System.out.println(f);
        //自增自减运算符
        int g = 5;
        System.out.println(g++); //g=g+1;  先使用变量，再进行累加
        System.out.println(++g);  //g=g+1;  先进行累加，再使用变量
        System.out.println(g--);  //g=g-1;  先使用变量，再进行累减
        System.out.println(--g);  //g=g-1;  先进行累减，再使用变量
    }
}
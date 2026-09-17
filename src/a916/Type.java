package a916;

public class Type {
    public static void main(String[] args) {
        //byte b=100;
        //short s=b;
        //int i=b;
        //long l=b;
        //float f=b;
        //double d=f;
        //System.out.println(b);
        ////System.out.println(d);
        //long l=200;
        //int i=(int)l;
        //short s=(short)i;
        //byte b=(byte)s;
        //System.out.println(l);
        //System.out.println(i);
        //System.out.println(s);
        //System.out.println(b);
        char c = '我'; //2个字节  0-65535
        System.out.println((int)c);
        System.out.println((char)25105);
        String sage = "123"; //是一个字符串，不能进行运算
        System.out.println(Integer.parseInt(sage)+1);
        System.out.println(Float.parseFloat(sage)+1);
        int i=100;
        System.out.println((i+"")+1);
        System.out.println(String.valueOf(i)+1);
    }
}

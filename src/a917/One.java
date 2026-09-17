package a917;

public class One {
    public static int get(int num1, int num2) {
        while (num2 != 0) {
            int yu = num1 % num2;
            num1 = num2;
            num2 = yu;
        }
        return num1;
    }
    public static void main(String[] args) {
        int Max_shu = One.get(12, 16);
        System.out.println(Max_shu);

    }
}

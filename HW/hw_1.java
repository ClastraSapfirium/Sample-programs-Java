package HW;
import java.util.Scanner;
public class hw_1 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Введите числовое значение для которого нужно посчитать треугольное число: ");
        int a = Scanner.nextInt();
        Scanner.close();
        System.out.println("Треугольное число = " + Clock(a) + "\n");
    }
    public static int Clock(int num) {
        if (num == 1) {
            return 1;
        }
        return Clock(num - 1) + num;
    }
}
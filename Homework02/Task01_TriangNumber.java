
import java.util.Scanner;

public class Task01_TriangNumber {
    public static void main(String[] args) {
        int triangNum = setTriangNumber(getNumber());
        System.out.println(triangNum == 0 ? "Данные введены неверно" : triangNum);
    }

    public static int getNumber() {
        Scanner num = new Scanner(System.in);
        System.out.printf("Введите целое положительное число: ");
        int i = !num.hasNextInt() ? 0 : num.nextInt();
        num.close();
        return i;
    }

    public static int setTriangNumber(int num) {
        int triangNum = num < 1 ? 0 : num * (num + 1) / 2;
        return triangNum;
    }
}

import java.util.Scanner;

public class Task01_hanoiTower {

    public static void main(String args[]) {
        tower(getNumber(), "A", "C", "B");
    }

    static void tower(int n, String from, String to, String space) {
        if (n == 1) {
            System.out.printf("Перемещаем диск 1 со стержня %s на стержень %s \n", from, to);
            return;
        }

        tower(n - 1, from, space, to);
        System.out.printf("Перемещаем диск %s со стержня %s на стержень %s \n", n, from, to);
        tower(n - 1, space, to, from);
    }

    public static int getNumber() {
        Scanner num = new Scanner(System.in);
        System.out.printf("Введите количество дисков (целое положительное число): ");
        int i = !num.hasNextInt() ? 0 : num.nextInt();
        num.close();
        return i;
    }
}

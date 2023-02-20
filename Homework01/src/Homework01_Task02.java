/**
 * Вывести все простые числа от 1 до 1000.
 */
public class Homework01_Task02 {
    public static void main(String[] args) {
        System.out.println("Простые числа от 1 до 1000:");
        System.out.print("1 ");
        System.out.print("2");
        int j = 0;
        for (int i = 3; i <= 1000; i = i + 2) {
            if (checkNaturalNumber(i)) {
                int q = i / 100;
                if (q == j) {
                    System.out.print(" " + i);
                } else {
                    j++;
                    System.out.print("\n" + i);
                }
            }
        }
    }

    private static boolean checkNaturalNumber(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)  return false;
        }
        return true;
    }
}

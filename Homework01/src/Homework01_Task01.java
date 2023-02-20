import java.util.Scanner;

/**
 * Вычислить n-ое треугольное число (сумма чисел от 1 до n) и n! (произведение чисел от 1 до n).
 * */
public class Homework01_Task01 {
    public static void main(String[] args) {
        int num = getNumber();
        System.out.println(num + "-ое треугольное число: " + getTriangleNumber(num));
        System.out.println("Факториал числа " + num + ": " + getFactorial(num));
    }

    private static int getNumber() {
        int number = 0;
        boolean isNumberPositive = false;

        while (!isNumberPositive) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nВведите целое положительное число: ");
            String selectNumber = input.nextLine();
            try{
                number = Integer.parseInt(selectNumber);
                if (number <= 0) {
                    System.out.println("Нужно ввести положительное число");
                } else {
                    isNumberPositive = true;
                }
            } catch (NumberFormatException ex){
                System.out.println(selectNumber + " не является целым числом");
            }
        }
        return number;
    }

    private static int getTriangleNumber(int num) {
        int result = num * (num + 1) / 2;
        return result;
    }

    private static int getFactorial(int num) {
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact = fact * i;
        }

        return fact;
    }
}

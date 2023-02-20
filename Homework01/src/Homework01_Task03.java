import java.util.Scanner;

/**
 * Реализовать простой калькулятор.
 */
public class Homework01_Task03 {
    public static void main(String[] args) {
        System.out.println("Простой калькулятор");
        System.out.println(calculateExpression(getDataExpression()));
    }

    private static String[] getDataExpression() {
        String[] dataExpr = new String[3];

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        dataExpr[0] = sc.nextLine();
        System.out.print("Введите знак выражения: ");
        dataExpr[2] = sc.nextLine();
        System.out.print("Введите второе число: ");
        dataExpr[1] = sc.nextLine();
        sc.close();

        return dataExpr;
    }

    private static String calculateExpression(String[] arr) {
        try {
            double num1 = Double.parseDouble(arr[0]);
            double num2 = Double.parseDouble(arr[1]);
            String result;

            switch (arr[2]) {
                case "+":
                    result = String.valueOf(num1 + num2);
                    break;
                case "-":
                    result = String.valueOf(num1 - num2);
                    break;
                case "*":
                    result = String.valueOf(num1 * num2);
                    break;
                case "/":
                    result = String.valueOf(num1 / num2);
                    break;
                default:
                    return "Введены неверные данные. Калькулятор сгорел.";
            }

            return String.format("%s %s %s = %s", num1, arr[2], num2, result);

        } catch (NumberFormatException ex) {
            return "Введены неверные данные. Калькулятор сгорел.";
        }
    }
}

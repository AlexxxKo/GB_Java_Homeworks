// Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
// Пример 1: а = 3, b = 2, ответ: 9
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1
// Пример 4: а = 0, b = 0, ответ: не определено //??? любое число в нулевой степени = 1
// Пример 5
// входные данные находятся в файле input.txt в виде
// b 3
// a 10
// Результат нужно сохранить в файле output.txt

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Homework01_Task01
 */
public class Homework01_Task01 {
  public static void main(String[] args) {
    int a = 3;
    int b = 2;
    printRes(myPow(a, b));

    a = 2;
    b = -2;
    printRes(myPow(a, b));

    a = 3;
    b = 0;
    printRes(myPow(a, b));

    a = 3;
    b = 0;
    printRes(myPow(a, b));

    int[] nums = readFile();
    double res = myPow(nums[0], nums[1]);
    if (res % 1 != 0)
      writeFile(Double.toString(res));
    else
      writeFile(Integer.toString((int) res));
  }

  static double myPow(int num, int deg) {
    double result = 1;
    boolean isNegative = deg < 0 ? true : false;
    deg = Math.abs(deg);

    while (deg > 0) {
      if (deg % 2 == 0) {
        deg /= 2;
        num *= num;
      } else {
        deg--;
        result *= num;
      }
    }

    if (isNegative)
      result = 1 / result;

    return result;
  }

  static int[] readFile() {
    int[] arr = new int[2];
    try {
      FileReader fr = new FileReader("input.txt");
      BufferedReader reader = new BufferedReader(fr);

      int i = 0;

      String line = reader.readLine();
      while (line != null) {
        arr[i] = Integer.parseInt(line.substring(2).trim());
        line = reader.readLine();
        i++;
      }
      fr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return arr;
  }

  static void writeFile(String str) {
    try (FileWriter fw = new FileWriter("output.txt", false)) {
      fw.write(str);
      fw.flush();
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  static void printRes(double num) {
    if (num % 1 != 0)
      System.out.println(num);
    else
      System.out.println((int) num);
  }
}
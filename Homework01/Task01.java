// На вход некоторому исполнителю подаётся два числа (a, b).
// У исполнителя есть две команды
// - команда 1 (к1): увеличить в с раза, а умножается на c
// - команда 2 (к2): увеличить на d, к a прибавляется d
// написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
// Пример 1: а = 1, b = 7, c = 2, d = 1
// ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2 
// Пример 2: а = 11, b = 7, c = 2, d = 1
// ответ: нет решения. 
// *Подумать над тем, как сделать минимальное количество команд

/**
 * App
 */
public class Task01 {

  static int[] solve(int start, int end, int k1, int k2) {
    int[] ways = new int[end + 1];
    if (start < end) {
      ways[start] = 1;

      for (int index = start + k2; index <= end; index++) {
        if (index % k1 == 0) {
          ways[index] = ways[index - k2] + ways[index / k1];
        } else {
          ways[index] = ways[index - k2];
        }
      }
    }

    return ways;
  }

  static String elems(int[] arr, int start, int k1, int k2) {
    String s = "";
    if (arr[arr.length - 1] != 0) {
      int i = arr.length - 1;
      while (i >= start) {
        if (i % k1 == 0 && i / k1 >= start && arr[i / k1] != 0) {
          s = String.format(" * %d", k1) + s;
          i /= k1;
        } else if (i - k2 >= start && arr[i - k2] != 0) {
          s = String.format(" + %d", k2) + s;
          i -= k2;
        } else {
          break;
        }
      }
    } else {
      s = "Нет решений";
    }
    return s;
  }

  static String preprint(int start, int end, int k1, int k2) {
    String s = elems(solve(start, end, k1, k2), start, k1, k2);
    s = s != "Нет решений" ? start + s + " = " + end : s;
    return s;
  }

  public static void main(String[] args) {
    System.out.println(preprint(1, 7, 2, 1));
  }
}
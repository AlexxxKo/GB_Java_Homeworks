import java.util.Random;
import java.util.Scanner;

/**
 * Реализовать алгоритм сортировки слиянием.
 */
public class Homework03_Task01 {
    public static void main(String[] args) {
        int arrLength = getArrayDimension();
        if (arrLength > 0) {
            int[] arr = createArray(arrLength);
            printArray(arr, "Заданный массив:");

            int[] resultArr = sortArray(arr);
            printArray(resultArr, "Отсортированный массив:");
        } else {
            System.out.println("Массив нулевой");
        }
    }
    private static int getArrayDimension() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int num = sc.nextInt();
        return num;
    }

    private static int[] createArray(int num) {
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            Random rnd = new Random();
            arr[i] = rnd.nextInt(-20, 20);
        }
        return arr;
    }

    private static int [] sortArray(int[] array1){
        if (array1 == null) {
            return null;
        }

        if (array1.length < 2) {
            return array1;
        }

        int [] array2 = new int[array1.length / 2];
        System.arraycopy(array1, 0, array2, 0, array1.length / 2);

        int [] array3 = new int[array1.length - array2.length];
        System.arraycopy(array1, array2.length, array3, 0, array1.length - array2.length);

        sortArray(array2);
        sortArray(array3);

        mergeArray(array1, array2, array3);

        return array1;
    }

    private static void mergeArray(int [] array1, int [] array2, int [] array3) {
        int position2 = 0, position3 = 0;

        for (int i = 0; i < array1.length; i++) {
            if (position2 == array2.length){
                array1[i] = array3[position3];
                position3++;
            } else if (position3 == array3.length) {
                array1[i] = array2[position2];
                position2++;
            } else if (array2[position2] < array3[position3]) {
                array1[i] = array2[position2];
                position2++;
            } else {
                array1[i] = array3[position3];
                position3++;
            }
        }
    }

    private static void printArray(int[] arr, String text) {
        System.out.println(text);
        System.out.print("[");
        int arrSize = arr.length;
        for (int i = 0; i < arrSize; i++) {
            if (i == arrSize - 1) System.out.printf("%s]\n", arr[i]);
            else System.out.printf("%s, ", arr[i]);
        }
    }
}

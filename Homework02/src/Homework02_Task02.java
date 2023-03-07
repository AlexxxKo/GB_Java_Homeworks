import java.util.Random;
import java.util.Scanner;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива.
 * Результат после каждой итерации запишите в лог-файл.
 */
public class Homework02_Task02 {
    public static void main(String[] args) {
        int arrayLength = setArrayLength();
        int[] arr = createArray(arrayLength);
        System.out.println("Начальный массив:");
        printArray(arr);
        System.out.println();
        System.out.println("Отсортированный массив:");
        printArray(bubbleSorter(arr));
    }

    private static int setArrayLength() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int sizeArray = sc.nextInt();
        sc.close();
        return sizeArray;
    }

    private static int[] createArray(int num) {
        int[] array = new int[num];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(-1000, 1000);
        }
        return array;
    }

    private static int[] bubbleSorter(int[] arr){
        for (int out = arr.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(arr[in] > arr[in + 1]) {
                    int temp = arr[in];
                    arr[in] = arr[in + 1];
                    arr[in + 1] = temp;
                }
            }
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) System.out.print(arr[i] + "]");
            else System.out.print(arr[i] + ", ");
        }
    }
}

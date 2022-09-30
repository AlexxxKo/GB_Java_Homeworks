import java.util.Arrays;
import java.util.Scanner;

public class Tak02_heapsort {
    public static void heapSort(int[] arr, int length) {
        int temp;
        int size = length - 1;
        for (int i = (length / 2); i >= 0; i--) {
            heapify(arr, i, size);
        }

        for (int i = size; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[size];
            arr[size] = temp;
            size--;
            heapify(arr, 0, size);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int[] myArray, int i, int size) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int large;
        if (left <= size && myArray[left] > myArray[i]) {
            large = left;
        } else {
            large = i;
        }
        if (right <= size && myArray[right] > myArray[large]) {
            large = right;
        }
        if (large != i) {
            int temp = myArray[i];
            myArray[i] = myArray[large];
            myArray[large] = temp;
            heapify(myArray, large, size);
        }
    }

    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите размер массива ");
            int size = scanner.nextInt();
            System.out.println("Введите элементы массива ");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
            heapSort(arr, size);
        }
    }
}

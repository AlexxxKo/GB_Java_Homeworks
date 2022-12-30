package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Положительных чисел перед отрицательными: " + Task01() + "\n");
        System.out.println("Сумма положительных чисел перед отрицательными: " + Task02() + "\n");
        System.out.println("Сумма простых чисел: " + Task03() + "\n");
        System.out.println(Task04() + "\n");
        System.out.println("Сумма элементов массива, у которых последние 2 цифры равны: " + Task05() + "\n");
        System.out.println("Итоговый массив" + Task06() + "\n");
    }

    static int Task01() {
        // Дана последовательность N целых чисел. Найти количество положительных чисел,
        // после которых следует отрицательное число.

        // Длина последовательности: 10
        // 8, -2, 7, 0, -3, -4, 8, 10, -9, 0
        // Результат: 2

        int n, countNumbers = 0, number, oldNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину последовательности:");
        n = scanner.nextInt();

        System.out.println("Введите число:");
        oldNumber = scanner.nextInt();

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Введите следующее число:");
            number = scanner.nextInt();
            if (number < 0 && oldNumber > 0) {
                countNumbers++;
            }
            oldNumber = number;
        }

        return countNumbers;
    }

    static int Task02() {
        // Дана последовательность целых чисел, оканчивающаяся нулем.
        // Найти сумму положительных чисел, после которых следует отрицательное число.

        // Длина последовательности: 10
        // 8, -2, 7, 0, -3, -4, 8, 10, -9, 0
        // Результат: 18

        int n, sumNumbers = 0, number, oldNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину последовательности:");
        n = scanner.nextInt();
        if (n < 3) { // если длина последовательности меньше 3 - последнее число 0, вводится максимум одно число.
            return sumNumbers;
        } else {
            System.out.println("Введите число:");
            oldNumber = scanner.nextInt();

            for (int i = 0; i < n - 2; i++) {
                System.out.println("Введите следующее число:");
                number = scanner.nextInt();
                if (number < 0 && oldNumber > 0) {
                    sumNumbers += oldNumber;
                }
                oldNumber = number;
            }
        }

        return sumNumbers;
    }

    static int Task03() {
        //Дана последовательность N целых чисел. Найти сумму простых чисел.

        // Длина последовательности: 10
        // 3, 2, 11, 8, 9, 7, 15, 14, 22, 21
        // Результат: 23

        int n, number, sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину последовательности:");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите число:");
            number = scanner.nextInt();
            if (Task03Simple(Math.abs(number))) {
                sum += number;
            }
        }

        return sum;
    }

    static boolean Task03Simple(int num) {
        int temp;
        boolean isPrime = true;
        if (num > 1) {
            for (int i = 2; i <= num / 2; i++) {
                temp = num % i;
                if (temp == 0) {
                    isPrime = false;
                    break;
                }
            }
        } else {
            isPrime = false;
        }

        return isPrime;
    }

    static String Task04() {
        // Дана последовательность из N целых чисел.
        // Верно ли, что последовательность является возрастающей?

        // Длина последовательности: 10
        // -6, -4, -2, 0, 3, 9, 10, 11, 12, 111
        // Результат: Последовательность является возрастающей
        // -6, -1, -2, 0, 3, 9, 10, 11, 12, 111
        // Результат: Последовательность не является возрастающей

        int n, number, oldNumber;
        String increase = "Последовательность является возрастающей";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину последовательности:");
        n = scanner.nextInt();

        if (n > 1) {
            System.out.println("Введите число:");
            oldNumber = scanner.nextInt();

            for (int i = 0; i < n - 1; i++) {
                System.out.println("Введите следующее число:");
                number = scanner.nextInt();
                if (number <= oldNumber) {
                    increase = "Последовательность не является возрастающей";
                    break;
                }
                oldNumber = number;
            }
        } else {
            increase = "Последовательность не является возрастающей";
        }

        return increase;
    }

    static int Task05() {
        // Дан массив целых чисел. Найти сумму элементов, у которых последняя и предпоследняя цифры равны.

        // Длина последовательности: 6
        // 1, -55, 78, 133, 0, -999
        // Результат: -921

        int lastDigit, preLastDigit, sum = 0;

        int[] arr = SetArray();

        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > 10) {
                lastDigit = arr[i] % 10;
                preLastDigit = arr[i] / 10 % 10;
                if (lastDigit == preLastDigit) {
                    sum += arr[i];
                }
            }
        }

        return sum;
    }

    static String Task06() {
        // Дан массив целых чисел. Заменить отрицательные элементы на сумму индексов двузначных элементов массива.

        int sum = 0, absNum;
        int[] arr = SetArray();

        for (int i = 0; i < arr.length; i++) {
            absNum = Math.abs(arr[i]);
            if (absNum > 9 && absNum < 100) {
                sum += i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = sum;
            }
            if (i == 0) {
                sb.append(String.valueOf(arr[i]));
                continue;
            }
            sb.append(", " + String.valueOf(arr[i]));
        }
        sb.append("]");

        return String.valueOf(sb);
    }

    static int[] SetArray() {
        int lengthArr;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива:");
        lengthArr = scanner.nextInt();
        int[] arr = new int[lengthArr];

        for (int i = 0; i < lengthArr; i++) {
            System.out.println("Введите число:");
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        return arr;
    }
}
import java.util.ArrayList;
import java.util.Random;

/**
 * Задан целочисленный список ArrayList. Найти минимальное,
 * максимальное и среднее арифметическое этого списка.
 */
public class Homework03_Task03 {
    public static void main(String[] args) {
        ArrayList<Integer> randomList = new ArrayList<>();

        createRandomList(randomList);
        System.out.println("Начальный массив:");
        System.out.println(randomList);

        int[] minMaxSumList = calcMinMaxSum(randomList);

        System.out.printf("Минимум: %s\n", minMaxSumList[0]);
        System.out.printf("Максимум: %s\n", minMaxSumList[1]);
        System.out.printf("Среднее арифметическое: %s", (double) minMaxSumList[2] / randomList.size());
    }

    private static void createRandomList(ArrayList<Integer> randomList) {
        for (int i = 0; i < 20; i++) {
            Random number = new Random();
            randomList.add(number.nextInt(-20, 20));
        }
    }

    private static int[] calcMinMaxSum(ArrayList<Integer> randomList) {
        int[] minMaxSumList = new int[3];
        minMaxSumList[0] = randomList.get(0);
        minMaxSumList[1] = randomList.get(0);
        minMaxSumList[2] = randomList.get(0);
        for (int i = 1; i < randomList.size(); i++) {
            int num = randomList.get(i);

            if (num < minMaxSumList[0]) minMaxSumList[0] = num;
            else if (num > minMaxSumList[1]) minMaxSumList[1] = num;

            minMaxSumList[2] += num;
        }
        return minMaxSumList;
    }
}

import java.util.ArrayList;
import java.util.Random;

/**
 * Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
 */
public class Homework03_Task02 {
    public static void main(String[] args) {
        ArrayList<Integer> randomList = new ArrayList<>();
        createRandomList(randomList);

        System.out.println("Начальный массив:");
        System.out.println(randomList);

        removeEvenNumbers(randomList);

        System.out.println("\nИтоговый массив:");
        System.out.println(randomList);
    }

    private static void createRandomList(ArrayList<Integer> randomList) {
        Random number = new Random();
        for (int i = 0; i < 20; i++) {
            randomList.add(number.nextInt(-20, 20));
        }
    }

    private static void removeEvenNumbers(ArrayList<Integer> randomList) {
        for (int i = randomList.size() - 1; i >= 0; i--) {
            if (randomList.get(i) % 2 == 0) randomList.remove(i);
        }
    }
}

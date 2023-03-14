import java.util.LinkedList;
import java.util.Scanner;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет "перевернутый" список.
 */

public class Homework04_Task01 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        createList(ll, getListDimesion());

        System.out.println("Начальный список:");
        System.out.println(ll);

        LinkedList<Integer> ll1 = reverseList(ll);

        System.out.println("Перевёрнутый список:");
        System.out.println(ll1);
    }

    private static void createList(LinkedList<Integer> ll, int num) {
        for (int i = 0; i < num; i++) {
            ll.add(getRandomNumber());
        }
    }

    private static int getListDimesion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Размерность LinkedList? ");
        int num = sc.nextInt();
        return num;
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 101);
    }

    private static LinkedList<Integer> reverseList(LinkedList<Integer> startList) {
        LinkedList<Integer> resultList = new LinkedList<>();

        for (int i = startList.size() - 1; i >= 0; i--) {
            resultList.add(startList.get(i));
        }

        return resultList;
    }
}

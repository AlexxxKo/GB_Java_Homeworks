import java.util.LinkedList;
import java.util.Queue;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди,
 * dequeue() - возвращает первый элемент из очереди и удаляет его,
 * first() - возвращает первый элемент из очереди, не удаляя.
 */
public class Homework04_Task02 {
    private static LinkedList<Integer> ll = new LinkedList<>();
    public static void main(String[] args) {
        Enqueue(2);
        System.out.println("Первый элемент списка: " + First());
        Enqueue(3);
        Enqueue(-1);
        System.out.println("Первый элемент списка: " + First());
        System.out.println("Удалённый элемент: " + Dequeue());
        System.out.println("Первый элемент списка: " + First());
    }

    private static void Enqueue(int el) {
        ll.add(el);
        System.out.println(ll);
    }
    private static int Dequeue() {
        int num = ll.get(0);
        ll.remove(0);
        System.out.println(ll);
        return num;
    }

    private static int First() {
        System.out.println(ll);
        return ll.get(0);
    }
}

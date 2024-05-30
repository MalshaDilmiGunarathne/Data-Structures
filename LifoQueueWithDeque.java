import java.util.Deque;
import java.util.ArrayDeque;

public class LifoQueueWithDeque<T> {
    private Deque<T> deque;

    public LifoQueueWithDeque() {
        deque = new ArrayDeque<>();
    }

    public void push(T value) {
        deque.push(value);
    }

    public T pop() {
        if (deque.isEmpty()) {
            System.out.println("Queue is empty. Cannot pop.");
            return null;
        }
        return deque.pop();
    }

    public T peek() {
        if (deque.isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return deque.peek();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

    public static void main(String[] args) {
        LifoQueueWithDeque<Integer> queue = new LifoQueueWithDeque<>();
        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Top element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("Popped: " + queue.pop());
        }
    }
}

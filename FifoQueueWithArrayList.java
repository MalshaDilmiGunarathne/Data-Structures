import java.util.ArrayList;
import java.util.List;

public class FifoQueueWithArrayList<T> {
    private List<T> list;

    public FifoQueueWithArrayList() {
        list = new ArrayList<>();
    }

    public void enqueue(T value) {
        list.add(value);
    }

    public T dequeue() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        return list.remove(0);
    }

    public T peek() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        FifoQueueWithArrayList<Integer> queue = new FifoQueueWithArrayList<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
}

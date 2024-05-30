import java.util.LinkedList;
import java.util.Queue;

public class LifoQueueWithTwoFifo<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public LifoQueueWithTwoFifo() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(T value) {
        queue1.add(value);
    }

    public T pop() {
        if (queue1.isEmpty()) {
            System.out.println("Queue is empty. Cannot pop.");
            return null;
        }

        // Transfer all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // The last element is the one to pop
        T poppedValue = queue1.remove();

        // Swap the names of queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedValue;
    }

    public T peek() {
        if (queue1.isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }

        // Transfer all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // The last element is the one to peek
        T peekedValue = queue1.peek();

        // Transfer the last element to queue2
        queue2.add(queue1.remove());

        // Swap the names of queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return peekedValue;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int size() {
        return queue1.size() + queue2.size();
    }

    public static void main(String[] args) {
        LifoQueueWithTwoFifo<Integer> queue = new LifoQueueWithTwoFifo<>();
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

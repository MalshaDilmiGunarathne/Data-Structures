import java.util.Stack;

public class LifoQueueWithStack<T> {
    private Stack<T> stack;

    public LifoQueueWithStack() {
        stack = new Stack<>();
    }

    public void push(T value) {
        stack.push(value);
    }

    public T pop() {
        if (stack.isEmpty()) {
            System.out.println("Queue is empty. Cannot pop.");
            return null;
        }
        return stack.pop();
    }

    public T peek() {
        if (stack.isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        LifoQueueWithStack<Integer> queue = new LifoQueueWithStack<>();
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

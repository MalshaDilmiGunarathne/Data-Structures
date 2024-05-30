public class LifoQueueWithArray<T> {
    private T[] array;
    private int top;
    private int capacity;

    public LifoQueueWithArray(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (top == capacity - 1) {
            System.out.println("Queue is full. Cannot push.");
            return;
        }
        array[++top] = value;
    }

    public T pop() {
        if (top == -1) {
            System.out.println("Queue is empty. Cannot pop.");
            return null;
        }
        return array[top--];
    }

    public T peek() {
        if (top == -1) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        LifoQueueWithArray<Integer> queue = new LifoQueueWithArray<>(5);
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

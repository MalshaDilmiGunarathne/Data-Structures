public class FifoQueueWithArray<T> {
    private T[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public FifoQueueWithArray(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(T value) {
        if (size == capacity) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        array[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        T value = array[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public T peek() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        FifoQueueWithArray<Integer> queue = new FifoQueueWithArray<>(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        queue.dequeue(); // Queue is empty, cannot dequeue
    }
}

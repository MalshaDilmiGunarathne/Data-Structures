public class CircularQueue<Item> {
    private Item[] queue;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = (Item[]) new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queue[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Item item = queue[head];
        queue[head] = null;  // Optional: to avoid loitering
        head = (head + 1) % capacity;
        size--;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CircularQueue: ");
        for (int i = 0; i < size; i++) {
            sb.append(queue[(head + i) % capacity]);
            if (i < size - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        
        System.out.println(queue);  // Should print: CircularQueue: 1 -> 2 -> 3 -> 4 -> 5
        
        System.out.println(queue.dequeue());  // Should print: 1
        System.out.println(queue);  // Should print: CircularQueue: 2 -> 3 -> 4 -> 5

        queue.enqueue(6);
        System.out.println(queue);  // Should print: CircularQueue: 2 -> 3 -> 4 -> 5 -> 6
    }
}

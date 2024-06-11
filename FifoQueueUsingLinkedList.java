class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // Enqueue operation: Adds an element to the rear of the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    // Dequeue operation: Removes and returns the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot perform dequeue operation.");
            return -1; // or throw exception
        }
        int dequeuedData = this.front.data;
        this.front = this.front.next;

        // If front becomes null, then change rear also as null
        if (this.front == null) {
            this.rear = null;
        }

        return dequeuedData;
    }

    // Peek operation: Returns the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // or throw exception
        }
        return this.front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return this.front == null;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements to the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Peek the front element
        System.out.println("Front element is: " + queue.peek());

        // Dequeue elements from the queue
        System.out.println("Dequeued element is: " + queue.dequeue());
        System.out.println("Dequeued element is: " + queue.dequeue());

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Dequeue the last element
        System.out.println("Dequeued element is: " + queue.dequeue());

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}

public class Steque<Item> {
    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Steque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("pop from empty steque");
        }
        Item item = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return item;
    }

    public void enqueue(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return "Steque: " + sb.toString();
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(1);
        steque.push(2);
        steque.enqueue(3);
        steque.enqueue(4);
        System.out.println(steque);  // Should print: Steque: 2 -> 1 -> 3 -> 4

        System.out.println(steque.pop());  // Should print: 2
        System.out.println(steque);  // Should print: Steque: 1 -> 3 -> 4
    }
}

public class CircularDoublyLinkedList<Item> {
    private class Node {
        Item item;
        Node next;
        Node prev;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node head;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Item item = head.item;
        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Node tail = head.prev;
        Item item = tail.item;
        if (head.next == head) {
            head = null;
        } else {
            Node newTail = tail.prev;
            newTail.next = head;
            head.prev = newTail;
        }
        size--;
        return item;
    }

    public boolean contains(Item item) {
        if (isEmpty()) {
            return false;
        }
        Node current = head;
        do {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty";
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        do {
            sb.append(current.item).append(" <-> ");
            current = current.next;
        } while (current != head);
        sb.append("(back to start)");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);  // Should print: 2 <-> 1 <-> 3 <-> 4 <-> (back to start)

        System.out.println(list.removeFirst());  // Should print: 2
        System.out.println(list);  // Should print: 1 <-> 3 <-> 4 <-> (back to start)

        System.out.println(list.removeLast());  // Should print: 4
        System.out.println(list);  // Should print: 1 <-> 3 <-> (back to start)

        System.out.println(list.contains(3));  // Should print: true
        System.out.println(list.contains(5));  // Should print: false
    }
}

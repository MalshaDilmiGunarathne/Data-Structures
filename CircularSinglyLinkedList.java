public class CircularSinglyLinkedList<Item> {
    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node tail;
    private int size;

    public CircularSinglyLinkedList() {
        tail = null;
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
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        size++;
    }

    public void addLast(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Node head = tail.next;
        Item item = head.item;
        if (head == tail) {  // Only one element in the list
            tail = null;
        } else {
            tail.next = head.next;
        }
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Node current = tail.next;
        Item item = tail.item;
        if (current == tail) {  // Only one element in the list
            tail = null;
        } else {
            while (current.next != tail) {
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
        size--;
        return item;
    }

    public boolean contains(Item item) {
        if (isEmpty()) {
            return false;
        }
        Node current = tail.next;
        do {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        } while (current != tail.next);
        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty";
        }
        StringBuilder sb = new StringBuilder();
        Node current = tail.next;
        do {
            sb.append(current.item).append(" -> ");
            current = current.next;
        } while (current != tail.next);
        sb.append("(back to start)");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);  // Should print: 2 -> 1 -> 3 -> 4 -> (back to start)

        System.out.println(list.removeFirst());  // Should print: 2
        System.out.println(list);  // Should print: 1 -> 3 -> 4 -> (back to start)

        System.out.println(list.removeLast());  // Should print: 4
        System.out.println(list);  // Should print: 1 -> 3 -> (back to start)

        System.out.println(list.contains(3));  // Should print: true
        System.out.println(list.contains(5));  // Should print: false
    }
}

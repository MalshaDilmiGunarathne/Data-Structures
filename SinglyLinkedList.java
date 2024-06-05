public class SinglyLinkedList<Item> {
    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(Item item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (head.next == null) {
            Item item = head.item;
            head = null;
            size--;
            return item;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        Item item = current.next.item;
        current.next = null;
        size--;
        return item;
    }

    public boolean contains(Item item) {
        Node current = head;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.item).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);  // Should print: 2 -> 1 -> 3 -> 4 -> null

        System.out.println(list.removeFirst());  // Should print: 2
        System.out.println(list);  // Should print: 1 -> 3 -> 4 -> null

        System.out.println(list.removeLast());  // Should print: 4
        System.out.println(list);  // Should print: 1 -> 3 -> null

        System.out.println(list.contains(3));  // Should print: true
        System.out.println(list.contains(5));  // Should print: false
    }
}

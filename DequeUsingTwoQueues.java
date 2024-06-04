import java.util.LinkedList;
import java.util.Queue;

public class DequeUsingTwoQueues<Item> {
    private Queue<Item> frontQueue;
    private Queue<Item> backQueue;

    public DequeUsingTwoQueues() {
        frontQueue = new LinkedList<>();
        backQueue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return frontQueue.isEmpty() && backQueue.isEmpty();
    }

    public int size() {
        return frontQueue.size() + backQueue.size();
    }

    public void addFirst(Item item) {
        frontQueue.add(item);
    }

    public void addLast(Item item) {
        backQueue.add(item);
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        if (frontQueue.isEmpty()) {
            balanceQueues();
        }
        return frontQueue.poll();
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        if (backQueue.isEmpty()) {
            balanceQueues();
        }
        return backQueue.poll();
    }

    private void balanceQueues() {
        int totalSize = size();
        int halfSize = totalSize / 2;

        // If frontQueue is empty, move elements from backQueue to frontQueue
        while (frontQueue.size() < halfSize) {
            frontQueue.add(backQueue.poll());
        }
        // If backQueue is empty, move elements from frontQueue to backQueue
        while (backQueue.size() < halfSize) {
            backQueue.add(frontQueue.poll());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Deque: ");

        for (Item item : frontQueue) {
            sb.append(item).append(" <- ");
        }

        for (Item item : backQueue) {
            sb.append(item).append(" -> ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DequeUsingTwoQueues<Integer> deque = new DequeUsingTwoQueues<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        System.out.println(deque);  // Should print: Deque: 2 <- 1 <- 3 -> 4 -> 

        System.out.println(deque.removeFirst());  // Should print: 2
        System.out.println(deque);  // Should print: Deque: 1 <- 3 -> 4 -> 

        System.out.println(deque.removeLast());  // Should print: 4
        System.out.println(deque);  // Should print: Deque: 1 <- 3 ->
    }
}

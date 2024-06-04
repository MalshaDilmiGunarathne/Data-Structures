public class StackArray<Item> {
    private Item[] stack;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public StackArray(int capacity) {
        this.capacity = capacity;
        stack = (Item[]) new Object[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(Item item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public Item peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack); // Should print: Stack: 1 2 3
        System.out.println(stack.pop()); // Should print: 3
        System.out.println(stack); // Should print: Stack: 1 2
        System.out.println(stack.peek()); // Should print: 2
    }
}
